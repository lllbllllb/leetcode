package org.lllbllllb.problems.designtwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/design-twitter/">355. Design Twitter</a>
 */
class Twitter {

    private static final int MOST_RESENT = 10;

    private final Map<Integer, Deque<Tweet>> userIdToTweets = new HashMap<>();

    private final Map<Integer, Set<Integer>> rel = new HashMap<>();

    private final Timestamp timestamp = new Timestamp();

    public Twitter() {

    }

    public void postTweet(int userId, int tweetId) {
        if (!userIdToTweets.containsKey(userId)) {
            userIdToTweets.put(userId, new LinkedList<>());
        }

        var tweets = userIdToTweets.get(userId);

        if (tweets.size() == MOST_RESENT) {
            tweets.poll();
        }

        tweets.offer(new Tweet(tweetId, timestamp.get()));
    }

    public List<Integer> getNewsFeed(int userId) {
        var heap = new Heap<Tweet>();

        heap.stream(userIdToTweets.get(userId));

        for (var followee : rel.getOrDefault(userId, new HashSet<>())) {

            heap.stream(userIdToTweets.get(followee));
        }

        var res = new ArrayList<Integer>(MOST_RESENT);

        for (var t : heap.get()) {
            res.add(t.tweetId());
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!rel.containsKey(followerId)) {
            rel.put(followerId, new HashSet<>());
        }

        rel.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (rel.containsKey(followerId)) {
            rel.get(followerId).remove(followeeId);
        }
    }

    private static class Heap<T extends Comparable<T>> {

        private final PriorityQueue<T> pq = new PriorityQueue<T>(MOST_RESENT + 1);

        public void stream(Collection<T> data) {
            if (data == null) {
                return;
            }

            for (var d : data) {
                pq.offer(d);

                if (pq.size() > MOST_RESENT) {
                    pq.poll();
                }
            }
        }

        public List<T> get() {
            var res = new ArrayList<>(pq);
            res.sort(Comparator.reverseOrder());

            return res;
        }
    }

    private static class Timestamp {
        private int timestamp;

        public int get() {
            return timestamp++;
        }
    }

    private record Tweet(
        int tweetId,
        int id
    ) implements Comparable<Tweet> {

        @Override
        public int compareTo(Tweet o) {
            return id() - o.id();
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

package org.lllbllllb.problems.designtwitter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwitterTest {

    @Test
    void twitter1() {
        var twitter = new Twitter();

        twitter.postTweet(1, 5);

        assertThat(twitter.getNewsFeed(1)).containsExactly(5);

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);

        assertThat(twitter.getNewsFeed(1)).containsExactly(6, 5);

        twitter.unfollow(1, 2);

        assertThat(twitter.getNewsFeed(1)).containsExactly(5);
    }

    // "postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"
    // [1,2],[1,94],[2,505],[1,333],[2,22],[1,11],[1,205],[2,203],[1,201],[2,213],[1,200],[2,202],[1,204],[2,208],[2,233],[1,222],[2,211],                            [1],[1,2],[1],[1,2],[1]
    @Test
    void twitter2() {
        var twitter = new Twitter();

        twitter.postTweet(1, 5);
        twitter.postTweet(2, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(2, 22);
        twitter.postTweet(1, 11);
        twitter.postTweet(1, 205);
        twitter.postTweet(2, 203);
        twitter.postTweet(1, 201);
        twitter.postTweet(2, 213);
        twitter.postTweet(1, 200);
        twitter.postTweet(2, 202);
        twitter.postTweet(1, 204);
        twitter.postTweet(2, 208);
        twitter.postTweet(2, 233);
        twitter.postTweet(1, 222);
        twitter.postTweet(2, 211);

        assertThat(twitter.getNewsFeed(1)).containsExactly(222, 204, 200, 201, 205, 11, 333, 94, 2, 101);

        twitter.follow(1, 2);

        assertThat(twitter.getNewsFeed(1)).containsExactly(211, 222, 233, 208, 204, 202, 200, 213, 201, 203);

        twitter.unfollow(1, 2);

        assertThat(twitter.getNewsFeed(1)).containsExactly(222, 204, 200, 201, 205, 11, 333, 94, 2, 101);
    }

}

package org.lllbllllb.problems.handofstraights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/hand-of-straights/">846. Hand of Straights</a>
 */
class Solution {

    // 23 ms, 44.4 MB
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        var cardToCount = new HashMap<Integer, Integer>();

        for (var card : hand) {
            var cardCount = cardToCount.getOrDefault(card, 0);
            cardToCount.put(card, cardCount + 1);
        }

        for (var card : hand) {
            if (cardToCount.containsKey(card)) {
                for (int i = 0; i < groupSize; i++) {
                    var nextCard = card + i;
                    var nextCount = cardToCount.remove(nextCard);

                    if (nextCount == null) {
                        return false;
                    }

                    var newCount = nextCount - 1;

                    if (newCount != 0) {
                        cardToCount.put(nextCard, newCount);
                    }
                }
            }
        }

        return true;
    }

    // 36 ms, 44.7 MB
    public boolean isNStraightHand1(int[] hand, int groupSize) {
        var cardToCount = new HashMap<Integer, Integer>();

        for (var card : hand) {
            var cardCount = cardToCount.getOrDefault(card, 0);
            cardToCount.put(card, cardCount + 1);
        }

        var minHeap = cardToCount.keySet().toArray(Integer[]::new);

        Arrays.sort(minHeap);

        for (var card : minHeap) {
            var count = cardToCount.get(card);

            if (count != null) {
                for (int j = 1; j < groupSize; j++) {
                    var nextCard = card + j;
                    var nextCount = cardToCount.remove(nextCard);

                    if (nextCount == null || nextCount < count) {
                        return false;
                    }

                    var nextLeft = nextCount - count;

                    if (nextLeft != 0) {
                        cardToCount.put(nextCard, nextLeft);
                    }
                }
            }
        }

        return true;
    }

    // 62 ms, 44.7 MB
    public boolean isNStraightHand2(int[] hand, int groupSize) {
        var counter = new TreeMap<Integer, Integer>();

        for (var card : hand) {
            var cardCount = counter.getOrDefault(card, 0);
            counter.put(card, cardCount + 1);
        }

        while (counter.size() != 0) {
            var cardToCount = counter.pollFirstEntry();
            var card = cardToCount.getKey();
            var count = cardToCount.getValue();

            for (int i = 1; i < groupSize; i++) {
                var nextCard = card + i;
                var nextCardCount = counter.remove(nextCard);

                if (nextCardCount == null || nextCardCount < count) {
                    return false;
                }

                var nextCardsRem = nextCardCount - count;

                if (nextCardsRem > 0) {
                    counter.put(nextCard, nextCardsRem);
                }
            }
        }

        return true;
    }

    // Memory Limit Exceeded
    public boolean isNStraightHand3(int[] hand, int groupSize) {
        var min = hand[0];
        var max = hand[0];

        for (var card : hand) {
            min = Math.min(min, card);
            max = Math.max(max, card);
        }

        var counter = new int[max - min + 1];

        for (var card : hand) {
            counter[card - min]++;
        }

        var range = counter.length;

        for (int i = 0; i < range; i++) {
            var count = counter[i];

            if (count != 0) {
                for (int j = i + 1; j < i + groupSize; j++) {
                    if (j == range || counter[j] < count) {
                        return false;
                    }

                    counter[j] -= count;
                }
            }
        }

        return true;
    }
}

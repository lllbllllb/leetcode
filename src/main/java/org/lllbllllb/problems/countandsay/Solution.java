package org.lllbllllb.problems.countandsay;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/count-and-say/description/">38. Count and Say</a>
 */
// 7ms
class Solution {

    public String countAndSay(int n) {
        var queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(-1);

        var base = -1;
        var count = 0;

        while (n > 1) {
            if (base == -1) {
                base = queue.peekFirst();
            }

            var num = queue.pollFirst();

            if (num == base) {
                count++;
            } else {
                queue.add(count);
                queue.add(base);
                base = num;

                if (num == -1) {
                    queue.add(-1);
                    n--;
                    count = 0;
                } else {
                    count = 1;
                }
            }
        }

        queue.pollLast();

        var res = new StringBuilder();

        while (!queue.isEmpty()) {
            res.append(queue.pollFirst());
        }

        return res.toString();
    }

}

// 4ms
class Solution1 {

    public String countAndSay(int n) {
        var list = List.of(1);

        for (int i = 0; i < n - 1; i++) {
            list = countAndSay(list);
        }

        var res = new StringBuilder();

        for (int i : list) {
            res.append(i);
        }

        return res.toString();
    }

    private List<Integer> countAndSay(List<Integer> arr) {
        var res = new ArrayList<Integer>(arr.size() + 1);
        var base = arr.get(0);
        var count = 0;

        for (int i = 0; i < arr.size(); i++) {
            var val = arr.get(i);

            if (val.equals(base)) {
                count++;
            } else {
                res.add(count);
                res.add(base);
                base = val;
                count = 1;
            }
        }

        res.add(count);
        res.add(base);

        return res;
    }
}
package org.lllbllllb.leetcode.problems.happynumber;

/**
 * <a href="https://leetcode.com/problems/happy-number/">202. Happy Number</a>
 */
class Solution {

    // 0ms, 48.84MB
    public boolean isHappy(int n) {
        var slow = n;
        var fast = n;

        do {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int getNextNumber(int n) {
        var sum = 0;

        while (n > 0) {
            var dig = (n % 10);
            sum += (dig * dig);
            n = (n / 10);
        }

        return sum;
    }
}

// 0ms, 40.38MB
class Solution1 {

    public boolean isHappy(int n) {
        var sum = 0;

        while (n > 0) {
            var dig = (n % 10);
            sum += (dig * dig);
            n = (n / 10);
        }

        if (sum == 1) {
            return true;
        }

        if (sum == 4) { // saamnitelnaaaa, nu okay
            return false;
        }

        return isHappy(sum);
    }
}
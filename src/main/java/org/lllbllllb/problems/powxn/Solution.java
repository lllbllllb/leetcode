package org.lllbllllb.problems.powxn;

/**
 * <a href="https://leetcode.com/problems/powx-n/">50. Pow(x, n)</a>
 */
class Solution {

    // 0ms,
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (x == 1.0) {
            return 1;
        }

        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : x;
        }

        var res = x;
        var pow = 1;

        while (pow <= n / 2) {
            res *= res;
            pow *= 2;
        }

        if (n > 0) {
            return res * myPow(x, n - pow);
        }

        return 1 / (res * myPow(x, -(n + 1)));
    }
}

// Stack Overflow (brute force)
class Solution1 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (x == 1.0) {
            return 1;
        }

        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : x;
        }

        if (n > 0) {
            return x * myPow(x, n - 1);
        }

        return 1 / (x * myPow(x, -(n + 1)));
    }
}

// Time Limit Exceeded (brute force)
class Solution2 {

    // Time Limit Exceeded (brute force)
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (x == 1.0) {
            return 1;
        }

        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : x;
        }

        if (n > 0) {
            var res = x;

            for (int i = 0; i < (n - 1); i++) {
                res *= x;
            }

            return res;
        } else {
            var res = 1 / x;

            for (int i = 0; i < -(n + 1); i++) {
                res /= x;
            }

            return res;
        }
    }
}
package org.lllbllllb.leetcode.problems.gasstation;

/**
 * <a href="https://leetcode.com/problems/gas-station/">134. Gas Station</a>
 */
class Solution {

    // 2ms, 55.8 MB
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var station = 0;
        var totalBalance = 0;
        var balance = 0;

        for (int i = 0; i < gas.length; i++) {
            if (balance < 0) {
                balance = 0;
                station = i;
            }

            var localBalance = gas[i] - cost[i];
            balance += localBalance;
            totalBalance += localBalance;
        }

        if (totalBalance < 0) {
            return -1;
        }

        return station;
    }
}

// 1 ms, 62.6 MB
class Solution1 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        var n = gas.length;
        var tank = 0;
        var debt = Integer.MAX_VALUE;
        var maxDebtPos = 0;

        for (int i = 0; i < n; i++) {
            tank += (gas[i] - cost[i]);

            if (tank < debt) {
                debt = tank;
                maxDebtPos = i;
            }
        }

        if (tank > -1) {
            var start = maxDebtPos + 1;

            return start < n ? start : start - n;
        }

        return -1;
    }
}

// 926 ms
class Solution2 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        var n = gas.length;

        for (int i = 0; i < n; i++) {
            if (gas[i] == 0 || cost [i] > gas[i]) {
                continue;
            }

            var tank = 0;
            var stationCount = 0;

            while (tank > -1) {
                if (stationCount == n) {
                    return i;
                }

                var station = i + stationCount;

                if (station > n - 1) {
                    station -= n;
                }

                tank += (gas[station] - cost[station]);

                stationCount++;
            }
        }

        return -1;
    }
}

package org.lllbllllb.problems.mergetripletstoformtargettriplet;

/**
 * <a href="https://leetcode.com/problems/merge-triplets-to-form-target-triplet/">1899. Merge Triplets to Form Target Triplet</a>
 */
class Solution {

    // 1 ms, 104.5 MB
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        var mark = new boolean[3];

        for (var triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            mark[0] = mark[0] || triplet[0] == target[0];
            mark[1] = mark[1] || triplet[1] == target[1];
            mark[2] = mark[2] || triplet[2] == target[2];

            if (mark[0] && mark[1] && mark[2]) {
                return true;
            }
        }

        return false;
    }
}

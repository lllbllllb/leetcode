package org.lllbllllb.leetcode.problems.findtheduplicatenumber;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">287. Find the Duplicate Number</a>
 */
// 4 ms, 59.9 MB
class Solution {

    public int findDuplicate(int[] nums) {
        var slow = nums[0];
        var fast = nums[0];
        var onWay = false;

        while (true) {
            if (onWay && slow == fast) {
                fast = nums[0];

                while (fast != slow) {
                    slow = nums[slow];
                    fast = nums[fast];
                }

                return slow;
            }

            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];

            if (!onWay) {
                onWay = true;
            }
        }
    }
}

// 5 ms, 60.2 MB
class Solution3 {

    public int findDuplicate(int[] nums) {
        var slow = nums[0];
        var fast = nums[0];
        var idx = 0;

        while (idx == 0 || slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
            idx++;
        }

        fast = nums[0];

        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

// 7 ms, 60 MB
class Solution2 {

    public int findDuplicate(int[] nums) {
        var res = -1;

        for (int i = 0; i < nums.length; i++) {
            var val = nums[i] > 0 ? nums[i] : -nums[i];

            if (res < 0 && nums[val] < 0) {
                res = val;
                i = 0;
            } else if (res > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
            } else {
                nums[val] = -nums[val];
            }
        }

        return res;
    }
}

// 5 ms, 59.5 MB
class Solution1 {

    public int findDuplicate(int[] nums) {
        var res = -1;

        for (var val : nums) {
            var idx = Math.abs(val);

            if (nums[idx] < 0) {
                res = Math.abs(val);
                break;
            } else {
                nums[idx] = -nums[idx];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return res;
    }
}

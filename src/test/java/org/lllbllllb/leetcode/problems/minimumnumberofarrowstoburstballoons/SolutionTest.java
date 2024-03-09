package org.lllbllllb.leetcode.problems.minimumnumberofarrowstoburstballoons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    /*
     * [10,16],[2,8],[1,6], [7,12]
     * [1,6],  [2,8],[7,12],[10,16]
     * [1,6],  [2,8],[7,12],[10,16]
     *
     * ------
     *  -------
     *       ------
     *          -------
     */
    @Test
    void findMinArrowShots1() {
        var res = solution.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});

        assertEquals(2, res);
    }

    /*
     * --
     *   --
     *     --
     *       --
     */
    @Test
    void findMinArrowShots2() {
        var res = solution.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});

        assertEquals(4, res);
    }

    /*
     * --
     *  --
     *   --
     *    --
     */
    @Test
    void findMinArrowShots3() {
        var res = solution.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});

        assertEquals(2, res);
    }

    /*
     * [2,8], [1,10], [7,12], [6,16]
     *
     * ----------
     *  -------
     *      -----------
     *       ------
     */
    @Test
    void findMinArrowShots4() {
        var res = solution.findMinArrowShots(new int[][]{{6, 16}, {2, 8}, {1, 10}, {7, 12}});

        assertEquals(1, res);
    }

    /*
     * [2,4],[6,10],[1,12],[13,16]
     *
     * ------------
     *  ---
     *      -----
     *           ------
     */
    @Test
    void findMinArrowShots5() {
        var res = solution.findMinArrowShots(new int[][]{{1, 12}, {2, 4}, {6, 10}, {13, 16}});

        assertEquals(3, res);
    }
}

package org.lllbllllb.leetcode.problems.insertinterval;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void insert1() {
        var res = solution.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});

        assertThat(res).isDeepEqualTo(new int[][]{{1, 5}, {6, 9}});
    }

    @Test
    void insert2() {
        var res = solution.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});

        assertThat(res).isDeepEqualTo(new int[][]{{1, 2}, {3, 10}, {12, 16}});
    }

    @Test
    void insert3() {
        var res = solution.insert(new int[][]{{1, 5}}, new int[]{2, 3});

        assertThat(res).isDeepEqualTo(new int[][]{{1, 5}});
    }

    @Test
    void insert4() {
        var res = solution.insert(new int[][]{{1, 5}}, new int[]{6, 8});

        assertThat(res).isDeepEqualTo(new int[][]{{1, 5}, {6, 8}});
    }

    @Test
    void insert5() {
        var res = solution.insert(new int[][]{{1, 5}}, new int[]{0, 0});

        assertThat(res).isDeepEqualTo(new int[][]{{0, 0}, {1, 5}});
    }

    @Test
    void insert6() {
        var res = solution.insert(new int[][]{{0, 2}, {3, 9}}, new int[]{6, 8});

        assertThat(res).isDeepEqualTo(new int[][]{{0, 2}, {3, 9}});
    }

    @Test
    void insert7() {
        var res = solution.insert(new int[][]{{0, 2}, {3, 3}, {6, 11}}, new int[]{9, 15});

        assertThat(res).isDeepEqualTo(new int[][]{{0, 2}, {3, 3}, {6, 15}});
    }
}

package org.lllbllllb.problems.jumpgameii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void jump1() {
        var res = solution.jump(new int[]{2, 3, 1, 1, 4});

        assertEquals(2, res);
    }

    @Test
    void jump2() {
        var res = solution.jump(new int[]{2, 3, 0, 1, 4});

        assertEquals(2, res);
    }

    @Test
    void jump3() {
        var res = solution.jump(new int[]{3, 1, 3, 1, 1, 4});

        assertEquals(2, res);
    }

    @Test
    void jump4() {
        var res = solution.jump(new int[]{1, 1, 1, 1});

        assertEquals(3, res);
    }

    @Test
    void jump5() {
        var res = solution.jump(new int[]{2, 0, 2, 4, 6, 0, 0, 3});

        assertEquals(3, res);
    }

    @Test
    void jump6() {
        var res = solution.jump(new int[]{1});

        assertEquals(0, res);
    }
}

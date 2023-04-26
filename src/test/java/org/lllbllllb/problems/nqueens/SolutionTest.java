package org.lllbllllb.problems.nqueens;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    /*
    * [ ][+][ ][ ]    [ ][ ][+][ ]
    * [ ][ ][ ][+]    [+][ ][ ][ ]
    * [+][ ][ ][ ]    [ ][ ][ ][+]
    * [ ][ ][+][ ]    [ ][+][ ][ ]
    */
    @Test
    void solveNQueens1() {
        var res = solution.solveNQueens(4);

        assertThat(res).containsExactlyInAnyOrder(
            List.of(".Q..", "...Q", "Q...", "..Q."),
            List.of("..Q.", "Q...", "...Q", ".Q..")
        );
    }

    /*
    * [+]
    */
    @Test
    void solveNQueens2() {
        var res = solution.solveNQueens(1);

        assertThat(res).containsExactlyInAnyOrder(List.of("Q"));
    }

    /*
    * [+][ ][ ]
    * [ ][ ][+]
    * [ ][+][ ] <--- (!)
    */
    @Test
    void solveNQueens3() {
        var res = solution.solveNQueens(3);

        assertThat(res).containsExactlyInAnyOrder();
    }
}

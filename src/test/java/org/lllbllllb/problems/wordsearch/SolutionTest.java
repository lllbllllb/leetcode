package org.lllbllllb.problems.wordsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    /*
        'A','B','C','E'
        'S','F','C','S'
        'A','D','E','E'
    */
    @Test
    void exist1() {
        var res = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED");

        assertTrue(res);
    }

    @Test
    void exist2() {
        var res = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE");

        assertTrue(res);
    }

    /*
        'A','B','C','E'
        'S','F','C','S'
        'A','D','E','E'
    */
    @Test
    void exist3() {
        var res = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB");

        assertFalse(res);
    }

    @Test
    void exist4() {
        var res = solution.exist(new char[][]{{'a', 'b'}}, "ba");

        assertTrue(res);
    }

    /*
        'C','A','A'
        'A','A','A'
        'B','C','D'
    */
    @Test
    void exist5() {
        var res = solution.exist(new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB");

        assertTrue(res);
    }

    /*
        'A','B','C','E'
        'S','F','E','S'
        'A','D','E','E'
    */
    @Test
    void exist6() {
        var res = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS");

        assertTrue(res);
    }

    /*
        'A','B','C','E'
        'S','F','E','S'
        'A','D','E','E'
    */
    @Test
    void exist7() {
        var res = solution.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCEFSADEESE");

        assertTrue(res);
    }
}

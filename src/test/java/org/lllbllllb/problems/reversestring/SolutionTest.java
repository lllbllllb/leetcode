package org.lllbllllb.problems.reversestring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void reverseString1() {
        var source = new char[]{'h','e','l','l','o'};

        solution.reverseString(source);

        assertThat(source).containsExactly('o','l','l','e','h');

    }

    @Test
    void reverseString2() {
        var source = new char[]{'H','a','n','n','a','h'};

        solution.reverseString(source);

        assertThat(source).containsExactly('h','a','n','n','a','H');

    }
}

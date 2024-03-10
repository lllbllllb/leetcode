package org.lllbllllb.other.problems.almostidentical;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WordMatcherTest {

    @Test
    void almostIdentical1() {
        var words = List.of("hope", "hone", "hell", "hello");
        var matcher = new WordMatcher(words);

        assertThat(matcher.isMatch("hope")).isTrue(); // because 'hone' can change 'n' to 'p'
    }

    @Test
    void almostIdentical2() {
        var words = List.of("hope", "hone", "hell", "hello");
        var matcher = new WordMatcher(words);

        assertThat(matcher.isMatch("hell")).isFalse(); // because 'hell' only in a list and none word could change 1 character to another to become 'hell'
    }

    @Test
    void almostIdentical3() {
        var words = List.of("hope", "hone", "hell", "hello");
        var matcher = new WordMatcher(words);

        assertThat(matcher.isMatch("help")).isTrue();
    }

    @Test
    void almostIdentical5() {
        var words = List.of("abc", "bcd", "def");
        var matcher = new WordMatcher(words);

        assertThat(matcher.isMatch("deg")).isTrue();
    }

    @Test
    void almostIdentical6() {
        var words = List.of("abc", "bcd", "defz");
        var matcher = new WordMatcher(words);

        assertThat(matcher.isMatch("deg")).isFalse();
    }

    @Test
    void almostIdentical7() {
        var words = List.of("abc", "bcd", "degz");
        var matcher = new WordMatcher(words);

        assertThat(matcher.isMatch("deg")).isFalse();
    }
}
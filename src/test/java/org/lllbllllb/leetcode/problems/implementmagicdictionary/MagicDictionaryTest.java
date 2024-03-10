package org.lllbllllb.leetcode.problems.implementmagicdictionary;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MagicDictionaryTest {

    @Test
    void magicDictionary1() {
        var dict = new MagicDictionary();
        dict.buildDict("hello", "leetcode");

        assertAll(
                () -> assertThat(dict.search("hello")).isFalse(),
                () -> assertThat(dict.search("hhllo")).isTrue(),
                () -> assertThat(dict.search("hell")).isFalse(),
                () -> assertThat(dict.search("leetcoded")).isFalse()
        );
    }

    @Test
    void magicDictionary2() {
        var dict = new MagicDictionary();
        dict.buildDict("hello","hallo","leetcode","judge");

        assertAll(
                () -> assertThat(dict.search("hello")).isTrue(),
                () -> assertThat(dict.search("hallo")).isTrue(),
                () -> assertThat(dict.search("hell")).isFalse(),
                () -> assertThat(dict.search("leetcodd")).isTrue(),
                () -> assertThat(dict.search("judge")).isFalse()
        );
    }
}
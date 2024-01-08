package org.lllbllllb.problems.detectsquares;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectSquaresTest {

    @Test
    void detectSquaresTest1() {
        var obj = new DetectSquares();
        obj.add(new int[]{3, 10});
        obj.add(new int[]{11, 2});
        obj.add(new int[]{3, 2});
        var count1 = obj.count(new int[]{11, 10});
        var count2 = obj.count(new int[]{14, 8});
        obj.add(new int[]{11, 2});
        var count3 = obj.count(new int[]{11, 10});

        assertAll(
                () -> assertEquals(1, count1),
                () -> assertEquals(0, count2),
                () -> assertEquals(2, count3)
        );
    }
}
package org.lllbllllb.leetcode.problems.sumoftwointegers;

/**
 * <a href="https://leetcode.com/problems/sum-of-two-integers/">371. Sum of Two Integers</a>
 */
class Solution {

    public int getSum(int a, int b) {
        // Перенос
        var shift = 0;

        // терировать до тех пор, пока не закончится перенос на старший разряд
        while (b != 0) {
            // Выставить флаг под разрядами с установленными битами
            shift = (a & b);
            // Снять с первого слагаемого биты, разряд по которым уже учтен
            a ^= b;
            // Перенос переводится в старший разряд
            b = (shift << 1);
        }

        return a;
    }
}

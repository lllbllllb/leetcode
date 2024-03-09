package org.lllbllllb.leetcode.problems.detectsquares;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DetectSquaresTest {

    @Test
    void detectSquaresTest0() {
        var res = getTestCase(
                List.of("DetectSquares", "add", "add", "add", "count", "count", "add", "count"),
                toValues("]],[[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10")
        );

        assertThat(res).containsExactly(null, null, null, null, 1, 0, null, 2);
    }

    @Test
    void detectSquaresTest2() {
        var res = getTestCase(
                List.of("DetectSquares", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count"),
                toValues("]],[[419,351]],[[798,351]],[[798,730]],[[419,730]],[[998,1]],[[0,999]],[[998,999]],[[0,1]],[[226,561]],[[269,561]],[[226,604]],[[269,604]],[[200,274]],[[200,793]],[[719,793]],[[719,274]],[[995,99]],[[146,948]],[[146,99]],[[995,948]],[[420,16]],[[962,558]],[[420,558]],[[962,16]],[[217,833]],[[945,105]],[[217,105]],[[945,833]],[[26,977]],[[26,7]],[[996,7]],[[996,977]],[[96,38]],[[96,483]],[[541,483]],[[541,38]],[[38,924]],[[961,1]],[[961,924]],[[38,1]],[[438,609]],[[818,609]],[[818,229]],[[438,229")
        );

        assertThat(res).containsExactly(null, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 1);
    }

    @Test
    void detectSquaresTest3() {
        var res = getTestCase(
                List.of("DetectSquares", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count", "add", "add", "add", "count"),
                toValues("]],[[5,10]],[[10,5]],[[10,10]],[[5,5]],[[3,0]],[[8,0]],[[8,5]],[[3,5]],[[9,0]],[[9,8]],[[1,8]],[[1,0]],[[0,0]],[[8,0]],[[8,8]],[[0,8]],[[1,9]],[[2,9]],[[2,10]],[[1,10]],[[7,8]],[[2,3]],[[2,8]],[[7,3]],[[9,10]],[[9,5]],[[4,5]],[[4,10]],[[0,9]],[[4,5]],[[4,9]],[[0,5]],[[1,10]],[[10,1]],[[10,10]],[[1,1]],[[10,0]],[[2,0]],[[2,8]],[[10,8]],[[7,6]],[[4,6]],[[4,9]],[[7,9]],[[10,9]],[[10,0]],[[1,0]],[[1,9]],[[0,9]],[[8,1]],[[0,1]],[[8,9]],[[3,9]],[[10,9]],[[3,2]],[[10,2]],[[3,8]],[[9,2]],[[3,2]],[[9,8]],[[0,9]],[[7,9]],[[0,2]],[[7,2]],[[10,1]],[[1,10]],[[10,10]],[[1,1]],[[6,10]],[[2,6]],[[6,6]],[[2,10]],[[6,0]],[[6,2]],[[8,2]],[[8,0]],[[6,5]],[[7,4]],[[6,4]],[[7,5]],[[2,10]],[[8,4]],[[2,4]],[[8,10]],[[2,6]],[[2,5]],[[1,5]],[[1,6]],[[10,9]],[[10,0]],[[1,9]],[[1,0]],[[0,9]],[[5,9]],[[0,4]],[[5,4]],[[3,6]],[[9,0]],[[3,0]],[[9,6]],[[0,2]],[[1,1]],[[0,1]],[[1,2]],[[1,7]],[[8,0]],[[8,7]],[[1,0]],[[2,7]],[[4,5]],[[2,5]],[[4,7]],[[6,7]],[[3,7]],[[6,4]],[[3,4]],[[10,2]],[[2,10]],[[2,2]],[[10,10]],[[10,1]],[[1,10]],[[1,1]],[[10,10]],[[2,10]],[[2,9]],[[3,9]],[[3,10]],[[10,1]],[[1,10]],[[1,1]],[[10,10]],[[10,4]],[[10,3]],[[9,4]],[[9,3]],[[6,6]],[[6,10]],[[10,6]],[[10,10]],[[9,7]],[[4,7]],[[9,2]],[[4,2]],[[2,3]],[[2,1]],[[0,3]],[[0,1]],[[2,8]],[[10,8]],[[2,0]],[[10,0]],[[8,4]],[[2,10]],[[8,10]],[[2,4]],[[0,0]],[[9,9]],[[0,9]],[[9,0]],[[5,7]],[[5,8]],[[4,7]],[[4,8]],[[10,10]],[[10,1]],[[1,1]],[[1,10]],[[6,8]],[[7,8]],[[6,9]],[[7,9]],[[4,6]],[[1,6]],[[4,3]],[[1,3]],[[10,1]],[[1,10]],[[10,10]],[[1,1]],[[7,7]],[[7,10]],[[4,7]],[[4,10]],[[0,0]],[[8,0]],[[0,8]],[[8,8]],[[3,5]],[[2,4]],[[3,4]],[[2,5]],[[0,6]],[[0,2]],[[4,2]],[[4,6]],[[5,2]],[[9,6]],[[9,2]],[[5,6]],[[1,1]],[[1,10]],[[10,10]],[[10,1]],[[7,5]],[[2,0]],[[2,5]],[[7,0]],[[1,9]],[[1,2]],[[8,2]],[[8,9]],[[3,8]],[[3,3]],[[8,3]],[[8,8]],[[3,10]],[[9,10]],[[3,4]],[[9,4]],[[0,2]],[[0,10]],[[8,10]],[[8,2]],[[9,4]],[[8,4]],[[8,5]],[[9,5]],[[9,8]],[[4,3]],[[4,8]],[[9,3]],[[4,9]],[[0,5]],[[0,9]],[[4,5]],[[1,3]],[[3,5]],[[1,5]],[[3,3]],[[0,0]],[[0,8]],[[8,0]],[[8,8]],[[2,8]],[[10,0]],[[10,8]],[[2,0]],[[8,1]],[[0,9]],[[8,9]],[[0,1]],[[4,9]],[[4,6]],[[1,9]],[[1,6]],[[0,9]],[[0,8]],[[1,9]],[[1,8]],[[5,1]],[[5,6]],[[10,1]],[[10,6]],[[9,2]],[[2,2]],[[2,9]],[[9,9]],[[5,5]],[[8,5]],[[5,8]],[[8,8]],[[8,0]],[[1,0]],[[8,7]],[[1,7]],[[8,2]],[[5,5]],[[5,2]],[[8,5]],[[6,6]],[[6,8]],[[8,6]],[[8,8]],[[2,10]],[[10,2]],[[2,2]],[[10,10]],[[1,9]],[[8,2]],[[1,2]],[[8,9]],[[7,4]],[[7,2]],[[9,4]],[[9,2]],[[1,9]],[[1,0]],[[10,0]],[[10,9]],[[2,10]],[[2,3]],[[9,10]],[[9,3]],[[10,0]],[[1,0]],[[1,9]],[[10,9]],[[8,10]],[[1,10]],[[1,3]],[[8,3]],[[0,9]],[[9,9]],[[0,0]],[[9,0]],[[7,9]],[[8,9]],[[7,8]],[[8,8]],[[3,1]],[[9,7]],[[9,1]],[[3,7]],[[5,9]],[[6,9]],[[5,8]],[[6,8]],[[0,1]],[[0,10]],[[9,10]],[[9,1]],[[8,0]],[[8,2]],[[10,2]],[[10,0]],[[8,0]],[[0,8]],[[8,8]],[[0,0]],[[6,7]],[[5,8]],[[5,7]],[[6,8]],[[0,9]],[[0,2]],[[7,9]],[[7,2]],[[5,0]],[[5,5]],[[10,0]],[[10,5]],[[1,10]],[[10,10]],[[10,1]],[[1,1]],[[9,2]],[[9,10]],[[1,2]],[[1,10]],[[1,10]],[[10,1]],[[10,10]],[[1,1]],[[9,9]],[[0,9]],[[0,0]],[[9,0]],[[9,6]],[[9,3]],[[6,3]],[[6,6]],[[10,4]],[[6,0]],[[10,0]],[[6,4]],[[6,8]],[[0,2]],[[0,8]],[[6,2]],[[7,9]],[[0,9]],[[7,2]],[[0,2]],[[9,1]],[[9,10]],[[0,10]],[[0,1]],[[10,0]],[[10,9]],[[1,9]],[[1,0]],[[1,6]],[[1,9]],[[4,9]],[[4,6]],[[0,8]],[[1,9]],[[0,9]],[[1,8]],[[1,1]],[[9,1]],[[1,9]],[[9,9]],[[2,5]],[[2,9]],[[6,5]],[[6,9]],[[7,3]],[[2,3]],[[2,8]],[[7,8]],[[9,4]],[[4,4]],[[9,9]],[[4,9]],[[4,4]],[[2,4]],[[4,2]],[[2,2]],[[0,3]],[[0,2]],[[1,3]],[[1,2]],[[10,9]],[[10,2]],[[3,2]],[[3,9]],[[5,6]],[[10,6]],[[10,1]],[[5,1]],[[9,0]],[[0,9]],[[9,9]],[[0,0]],[[5,6]],[[9,2]],[[9,6]],[[5,2]],[[3,3]],[[10,3]],[[10,10]],[[3,10]],[[2,4]],[[2,10]],[[8,4]],[[8,10]],[[4,9]],[[1,9]],[[4,6]],[[1,6]],[[1,8]],[[9,0]],[[1,0]],[[9,8]],[[10,3]],[[5,8]],[[5,3]],[[10,8]],[[8,2]],[[0,10]],[[8,10]],[[0,2]],[[9,0]],[[2,7]],[[9,7]],[[2,0]],[[0,4]],[[5,9]],[[0,9]],[[5,4]],[[5,3]],[[10,3]],[[5,8]],[[10,8]],[[6,4]],[[7,4]],[[6,5]],[[7,5]],[[9,1]],[[0,1]],[[9,10]],[[0,10]],[[5,10]],[[5,7]],[[8,7]],[[8,10]],[[8,0]],[[8,7]],[[1,7]],[[1,0]],[[1,1]],[[9,9]],[[1,9]],[[9,1]],[[3,1]],[[3,5]],[[7,5]],[[7,1]],[[5,8]],[[5,3]],[[10,8]],[[10,3]],[[0,9]],[[2,7]],[[2,9]],[[0,7]],[[9,3]],[[9,7]],[[5,3]],[[5,7]],[[0,0]],[[9,0]],[[9,9]],[[0,9]],[[6,4]],[[4,2]],[[4,4]],[[6,2]],[[1,9]],[[1,5]],[[5,5]],[[5,9]],[[7,7]],[[0,7]],[[0,0]],[[7,0]],[[1,3]],[[1,9]],[[7,3]],[[7,9]],[[0,9]],[[9,9]],[[9,0]],[[0,0]],[[1,8]],[[3,6]],[[3,8]],[[1,6")
        );

        assertThat(res).containsExactly(null, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 2, null, null, null, 1, null, null, null, 1, null, null, null, 1, null, null, null, 2, null, null, null, 2, null, null, null, 2, null, null, null, 2, null, null, null, 5, null, null, null, 6, null, null, null, 2, null, null, null, 3, null, null, null, 3, null, null, null, 14, null, null, null, 3, null, null, null, 1, null, null, null, 2, null, null, null, 2, null, null, null, 4, null, null, null, 20, null, null, null, 4, null, null, null, 5, null, null, null, 10, null, null, null, 26, null, null, null, 8, null, null, null, 3, null, null, null, 7, null, null, null, 21, null, null, null, 20, null, null, null, 52, null, null, null, 6, null, null, null, 56, null, null, null, 2, null, null, null, 5, null, null, null, 17, null, null, null, 18, null, null, null, 13, null, null, null, 19, null, null, null, 102, null, null, null, 9, null, null, null, 2, null, null, null, 157, null, null, null, 23, null, null, null, 29, null, null, null, 23, null, null, null, 15, null, null, null, 24, null, null, null, 186, null, null, null, 12, null, null, null, 32, null, null, null, 36, null, null, null, 10, null, null, null, 35, null, null, null, 20, null, null, null, 43, null, null, null, 48, null, null, null, 35, null, null, null, 73, null, null, null, 59, null, null, null, 56, null, null, null, 72, null, null, null, 198, null, null, null, 37, null, null, null, 145, null, null, null, 130, null, null, null, 45, null, null, null, 68, null, null, null, 172, null, null, null, 281, null, null, null, 147, null, null, null, 53, null, null, null, 160, null, null, null, 105, null, null, null, 253, null, null, null, 82, null, null, null, 103, null, null, null, 248, null, null, null, 75, null, null, null, 86, null, null, null, 312, null, null, null, 301, null, null, null, 273, null, null, null, 119, null, null, null, 191, null, null, null, 61, null, null, null, 584, null, null, null, 696, null, null, null, 802, null, null, null, 293, null, null, null, 104, null, null, null, 114, null, null, null, 242, null, null, null, 259, null, null, null, 300, null, null, null, 465, null, null, null, 180, null, null, null, 1082, null, null, null, 697, null, null, null, 187, null, null, null, 113, null, null, null, 201, null, null, null, 520, null, null, null, 652, null, null, null, 197, null, null, null, 91, null, null, null, 670, null, null, null, 159, null, null, null, 189, null, null, null, 386, null, null, null, 403, null, null, null, 204, null, null, null, 301, null, null, null, 378, null, null, null, 314, null, null, null, 292, null, null, null, 352, null, null, null, 174, null, null, null, 2778, null, null, null, 473, null, null, null, 869, null, null, null, 1568, null, null, null, 190, null, null, null, 198, null, null, null, 342, null, null, null, 286, null, null, null, 1062, null, null, null, 475, null, null, null, 354, null, null, null, 174, null, null, null, 574, null, null, null, 1605, null, null, null, 547);
    }

    private List<Integer> getTestCase(
            List<String> ops,
            List<int[]> values
    ) {
        if (ops.size() != values.size()) {
            throw new IllegalArgumentException("%s != %s".formatted(ops.size(), values.size()));
        }

        var res = new ArrayList<Integer>();
        var obj = new DetectSquares();

        for (int i = 0; i < ops.size(); i++) {
            var op = ops.get(i);
            var point = values.get(i);

            if ("DetectSquares".equals(op)) {
                res.add(null);
            } else if ("add".equals(op)) {
                obj.add(point);
                res.add(null);
            } else if ("count".equals(op)) {
                res.add(obj.count(point));
            } else {
                throw new IllegalArgumentException(op);
            }
        }

        return res;
    }

    private List<int[]> toValues(String str) {
        return Arrays.stream(str.split("]],\\s?\\[\\["))
                .map(nums -> "".equals(nums) ? null : Arrays.stream(nums.split(",\\s?"))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toList();
    }
}
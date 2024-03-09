package org.lllbllllb.leetcode.problems.serializeanddeserializebinarytree;

import org.junit.jupiter.api.Test;
import org.lllbllllb.leetcode.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CodecTest {

    Codec ser = new Codec();

    Codec deser = new Codec();

    @Test
    void serDeser1() {
        var root = TreeNode.of(1, 2, 3, null, null, 4, 5);
        var res = deser.deserialize(ser.serialize(root));

        assertEquals(root, res);
    }

    @Test
    void serDeser2() {
        var res = deser.deserialize(ser.serialize(null));

        assertNull(res);
    }
}

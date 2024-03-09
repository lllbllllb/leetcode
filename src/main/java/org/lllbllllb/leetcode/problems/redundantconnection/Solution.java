package org.lllbllllb.leetcode.problems.redundantconnection;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/redundant-connection/">684. Redundant Connection</a>
 */
class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        var uf = new UnionFind(edges.length + 1);

        for (var edge : edges) {
            if (uf.unionPlain(edge[0], edge[1])) {
                return edge;
            }
        }

        return new int[0];
    }

    // https://dou.ua/lenta/articles/union-find/
    // https://habr.com/ru/articles/104772/
    private static class UnionFind {
        private final int[] trie;
        private final int[] rank;

        public UnionFind(int n) {
            trie = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                trie[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int v) {
            if (trie[v] == v) {
                return v;
            }

            return trie[v] = find(trie[v]);
        }

        // 1 ms, 42.9 MB
        public boolean unionBalancedRandom(int a, int b) {
            var aP = find(a);
            var bP = find(b);

            if (aP == bP) {
                return true;
            }

            if (new Random().nextInt() % 2 == 0) {
                trie[aP] = trie[bP];
            } else {
                trie[bP] = trie[aP];
            }

            return false;
        }

        // 1 ms, 42.8 MB
        public boolean unionBalancedRank(int a, int b) {
            var aP = find(a);
            var bP = find(b);

            if (aP == bP) {
                return true;
            }

            if (rank[aP] > rank[bP]) {
                trie[aP] = trie[bP];
            } else {
                trie[bP] = trie[aP];

                if (rank[aP] == rank[bP]) {
                    rank[bP]++;
                }
            }

            return false;
        }

        // 0 ms, 43.0 MB
        public boolean unionPlain(int a, int b) {
            var aP = find(a);
            var bP = find(b);

            if (aP == bP) {
                return true;
            }

            trie[aP] = trie[bP];

            return false;
        }
    }
}

package org.lllbllllb.leetcode.problems.reconstructitinerary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/reconstruct-itinerary/">332. Reconstruct Itinerary</a>
 */
class Solution {

    // 5 ms, 44.4 MB
    public List<String> findItinerary(List<List<String>> tickets) {
        var departureToArrivals = new HashMap<String, Queue<String>>();

        for (var ticket : tickets) {
            var depart = ticket.get(0);
            var dest = ticket.get(1);
            var step = departureToArrivals.computeIfAbsent(depart, d -> new PriorityQueue<>());
            step.add(dest);
        }

        var itinerary = new LinkedList<String>();

        dfs(departureToArrivals, "JFK", itinerary);

        return itinerary;
    }

    private void dfs(HashMap<String, Queue<String>> departureToArrivals, String ticket, Deque<String> itinerary) {
        var destinations = departureToArrivals.get(ticket);

        if (destinations == null || destinations.isEmpty()) {
            itinerary.addFirst(ticket);
        } else {
            dfs(departureToArrivals, destinations.poll(), itinerary);
            dfs(departureToArrivals, ticket, itinerary);
        }
    }

    // 7 ms, 44 MB
    public List<String> findItinerary1(List<List<String>> tickets) {
        var departureToArrivals = new HashMap<String, Queue<String>>();

        for (var ticket : tickets) {
            var dep = ticket.get(0);
            var dest = ticket.get(1);

            var forks = departureToArrivals.computeIfAbsent(dep, d -> new PriorityQueue<>());
            forks.add(dest);
        }

        var itinerary = new LinkedList<String>();
        var stack = new LinkedList<String>();

        stack.push("JFK");

        while (!stack.isEmpty()) {
            var dest = stack.peek();
            var destinations = departureToArrivals.get(dest);

            if (destinations == null || destinations.isEmpty()) {
                itinerary.addFirst(stack.pop());
            } else {
                stack.push(destinations.poll());
            }
        }

        return itinerary;
    }

    // 8 ms, 44.8 MB
    public List<String> findItinerary2(List<List<String>> tickets) {
        var departureToArrivals = new HashMap<String, List<Node>>();

        for (var ticket : tickets) {
            var depart = ticket.get(0);
            var dest = ticket.get(1);
            var step = departureToArrivals.computeIfAbsent(depart, d -> new ArrayList<>());
            step.add(new Node(dest));
        }

        for (var arrivals : departureToArrivals.values()) {
            arrivals.sort(Comparator.comparing(node -> node.dest)); // apply lexical order
        }

        var res = new ArrayList<String>();
        res.add("JFK");

        return dfs1(departureToArrivals, tickets.size(), res);
    }

    private List<String> dfs1(HashMap<String, List<Node>> departureToArrivals, int pathLeft, List<String> result) {
        if (pathLeft == 0) {
            return result;
        }

        var depart = result.get(result.size() - 1);
        var destinations = departureToArrivals.get(depart);

        if (destinations == null) {
            return null;
        }

        for (var dest : destinations) {
            if (!dest.visited) {
                dest.visited = true;
                result.add(dest.dest);

                var pathTmp = dfs1(departureToArrivals, pathLeft - 1, result);

                if (pathTmp != null) {
                    return pathTmp; // need just only first by lexical order
                }

                dest.visited = false;
                result.remove(result.size() - 1);
            }
        }

        return null;
    }

    private static class Node {

        final String dest;

        boolean visited;

        Node(String dest) {
            this.dest = dest;
        }
    }
}

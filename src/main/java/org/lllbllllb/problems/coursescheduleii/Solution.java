package org.lllbllllb.problems.coursescheduleii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/course-schedule-ii/">210. Course Schedule II</a>
 */
class Solution {

    // Node Indegree
    // 5 ms, 43.8 MB
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var courses = new ArrayList<List<Integer>>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        var nodeIndegree = new int[numCourses];

        for (var prerequisite : prerequisites) {
            courses.get(prerequisite[1]).add(prerequisite[0]);
            nodeIndegree[prerequisite[0]]++;
        }

        var coursesQueue = new LinkedList<Integer>();

        for (int course = 0; course < numCourses; course++) {
            if (nodeIndegree[course] == 0) {
                coursesQueue.offer(course);
            }
        }

        var topologicalOrderCursor = 0;
        var topologicalOrder = new int[numCourses];

        while (!coursesQueue.isEmpty()) {
            var course = coursesQueue.poll();
            topologicalOrder[topologicalOrderCursor] = course;
            topologicalOrderCursor++;

            for (var nextCourse : courses.get(course)) {
                nodeIndegree[nextCourse]--;

                if (nodeIndegree[nextCourse] == 0) {
                    coursesQueue.offer(nextCourse);
                }
            }
        }

        if (topologicalOrderCursor == numCourses) {
            return topologicalOrder;
        }

        return new int[0];
    }

    // DFS
    // 3 ms, 44.4 MB
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        var courses = new ArrayList<List<Integer>>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        for (var prerequisite : prerequisites) {
            courses.get(prerequisite[0]).add(prerequisite[1]);
        }

        var cycleDetector = new int[numCourses];
        var topologicalOrder = new ArrayList<Integer>();

        for (int course = 0; course < numCourses; course++) {
            if (cycleDetector[course] == 0) {
                if (isCycle(courses, course, cycleDetector, topologicalOrder)) {
                    return new int[0];
                }
            }
        }

        var res = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            res[i] = topologicalOrder.get(i);
        }

        return res;

    }

    private boolean isCycle(List<List<Integer>> courses, int course, int[] cycleDetector, List<Integer> topologicalOrder) {
        if (cycleDetector[course] == 2) {
            return true;
        }

        cycleDetector[course] = 2;

        for (var nextCourse : courses.get(course)) {
            if (cycleDetector[nextCourse] != 1) {
                if (isCycle(courses, nextCourse, cycleDetector, topologicalOrder)) {
                    return true;
                }
            }
        }

        topologicalOrder.add(course);
        cycleDetector[course] = 1;

        return false;
    }
}

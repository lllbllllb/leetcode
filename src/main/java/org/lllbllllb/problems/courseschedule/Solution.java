package org.lllbllllb.problems.courseschedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/course-schedule/">207. Course Schedule</a>
 */
class Solution {

    // 3 ms, 42.8 MB
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var courses = new ArrayList<List<Integer>>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        for (var prerequisite : prerequisites) {
            courses.get(prerequisite[0]).add(prerequisite[1]);
        }

        var cycleDetector = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (cycleDetector[course] == 0) {
                if (isCycledGraph(courses, course, cycleDetector)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCycledGraph(List<List<Integer>> courses, int course, int[] cycleDetector) {
        if (cycleDetector[course] == 2) {
            return true;
        }

        cycleDetector[course] = 2;

        for (var nextCourse : courses.get(course)) {
            if (cycleDetector[nextCourse] != 1) {
                if (isCycledGraph(courses, nextCourse, cycleDetector)) {
                    return true;
                }
            }
        }

        cycleDetector[course] = 1;

        return false;
    }

    // 5 ms, 43.3 MB
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        var courses = new HashMap<Integer, List<Integer>>();

        for (var prerequisite : prerequisites) {
            courses.computeIfAbsent(prerequisite[0], c -> new ArrayList<>()).add(prerequisite[1]);
        }

        var cycleDetector = new int[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (cycleDetector[course] == 0) {
                if (isCycledGraph(courses, course, cycleDetector)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isCycledGraph(Map<Integer, List<Integer>> courses, int course, int[] cycleDetector) {
        if (cycleDetector[course] == 2) {
            return true;
        }

        if (!courses.containsKey(course)) {
            return false;
        }

        cycleDetector[course] = 2;

        for (var nextCourse : courses.get(course)) {
            if (cycleDetector[nextCourse] != 1) {
                if (isCycledGraph(courses, nextCourse, cycleDetector)) {
                    return true;
                }
            }
        }

        cycleDetector[course] = 1;

        return false;
    }
}

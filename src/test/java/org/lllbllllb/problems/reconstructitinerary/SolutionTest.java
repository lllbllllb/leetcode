package org.lllbllllb.problems.reconstructitinerary;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findItinerary1() {
        var res = solution.findItinerary(List.of(
            List.of("MUC", "LHR"),
            List.of("JFK", "MUC"),
            List.of("SFO", "SJC"),
            List.of("LHR", "SFO")
        ));

        assertThat(res).containsExactly("JFK", "MUC", "LHR", "SFO", "SJC");
    }

    @Test
    void findItinerary2() {
        var res = solution.findItinerary(List.of(
            List.of("JFK", "SFO"),
            List.of("JFK", "ATL"),
            List.of("SFO", "ATL"),
            List.of("ATL", "JFK"),
            List.of("ATL", "SFO")
        ));

        assertThat(res).containsExactly("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
    }

    @Test
    void findItinerary3() {
        var res = solution.findItinerary(List.of(
            List.of("JFK", "KUL"),
            List.of("JFK", "NRT"),
            List.of("NRT", "JFK")
        ));

        assertThat(res).containsExactly("JFK", "NRT", "JFK", "KUL");
    }
}

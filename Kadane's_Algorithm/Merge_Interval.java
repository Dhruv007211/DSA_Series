/*
═══════════════════════════════════════════════════════════════
📅 DAY 7
📚 TOPIC : ARRAYS

❓ Ques 15.) Merge Intervals

Problem Statement:

Given an array of intervals where:

intervals[i] = [start, end]

Merge all overlapping intervals
and return the resulting intervals.

Example:

Input:

[[1,3],[2,6],[8,10],[15,18]]

Output:

[[1,6],[8,10],[15,18]]

Explanation:

[1,3] and [2,6] overlap.

Merged Interval:

[1,6]

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Sort intervals by starting time.
2. Pick current interval.
3. Compare with upcoming intervals.
4. Keep extending end point while overlap exists.
5. Add merged interval to answer.

Time Complexity : O(N²)
Space Complexity: O(N)

Pattern Used:
→ Sorting
→ Interval Merging

═══════════════════════════════════════════════════════════════
*/

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> ans = new ArrayList<>();

        int i = 0;

        while (i < intervals.length) {

            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            while (j < intervals.length && intervals[j][0] <= end) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            ans.add(new int[]{start, end});

            i = j;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Sorting + Greedy)
═══════════════════════════════════════════════════════════════

Description:

Observation:

After sorting:

If

currentStart <= previousEnd

Then intervals overlap.

Merge them by updating:

previousEnd =
max(previousEnd,currentEnd)

Otherwise:

Add new interval.

═══════════════════════════════════════════════════════════════

Dry Run:

intervals =

[[1,3],[2,6],[8,10],[15,18]]

After Sorting:

[[1,3],[2,6],[8,10],[15,18]]

--------------------------------

Take [1,3]

Answer:

[[1,3]]

--------------------------------

Take [2,6]

2 <= 3

Overlap Exists

Update:

End = max(3,6)

Answer:

[[1,6]]

--------------------------------

Take [8,10]

8 > 6

No Overlap

Add New Interval

Answer:

[[1,6],[8,10]]

--------------------------------

Take [15,18]

15 > 10

No Overlap

Answer:

[[1,6],[8,10],[15,18]]

═══════════════════════════════════════════════════════════════

Time Complexity : O(N log N)

Sorting → O(N log N)

Traversal → O(N)

Space Complexity : O(N)

Pattern Used:
→ Sorting
→ Greedy
→ Interval Merging

Why Optimal?

Only one traversal after sorting.

═══════════════════════════════════════════════════════════════
*/

import java.util.*;

class MergeIntervalsOptimal {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,
                (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for(int[] interval : intervals) {

            if(ans.isEmpty() ||
               ans.get(ans.size()-1)[1] < interval[0]) {

                ans.add(interval);

            } else {

                ans.get(ans.size()-1)[1] =
                    Math.max(
                        ans.get(ans.size()-1)[1],
                        interval[1]
                    );
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
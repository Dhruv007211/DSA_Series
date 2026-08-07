class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> ans = new ArrayList<>();

        boolean[] vis = new boolean[intervals.length];

        for (int i = 0; i < intervals.length; i++) {

            if (vis[i])
                continue;

            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int j = i + 1; j < intervals.length; j++) {

                if (intervals[j][0] <= end) {

                    end = Math.max(end, intervals[j][1]);
                    vis[j] = true;

                } else {
                    break;
                }
            }

            ans.add(new int[]{start, end});
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
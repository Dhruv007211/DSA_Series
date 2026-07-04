class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
          boolean[] visited = new boolean[intervals.length];
        ArrayList<int[]>ans=new ArrayList<>();
      for(int i=0;i<intervals.length;i++){
        if(visited[i])continue;
            int start=intervals[i][0];
            int end=intervals[i][1];
             for(int j = i + 1; j < intervals.length; j++) {

                if (!visited[j] && intervals[j][0] <= end) {

                end=Math.max(end,intervals[j][1]);
                 visited[j] = true;}
           
            }
                ans.add(new int[]{start,end});
               
            }
        
    return ans.toArray(new int[ans.size()][]);
    }
}
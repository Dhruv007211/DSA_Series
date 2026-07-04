class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        ArrayList<int[]>ans=new ArrayList<>();
        int i=0;
        while(i<intervals.length){
            int start=intervals[i][0];
            int end=intervals[i][1];
            int j=1+i;
            while(j<intervals.length&&intervals[j][0]<=end){
                end=Math.max(end,intervals[j][1]);
                j++;
            }
                ans.add(new int[]{start,end});
                i=j;
            }
        
    return ans.toArray(new int[ans.size()][]);
    }
}
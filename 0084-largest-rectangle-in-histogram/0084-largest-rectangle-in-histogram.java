class Solution {
    public int largestRectangleArea(int[] heights) {
         Stack<Integer>st=new Stack<>();
        int max=0;
        for(int i=0;i<=heights.length;i++){
                       while (!st.isEmpty() &&
                  (i == heights.length || heights[st.peek()] >= heights[i])) {


               int h=heights[st.pop()];
               
            int w;
            if(st.isEmpty()){
             w=i;
            }
            else{
              w=i-st.peek()-1;
            }
            max=Math.max(max,h*w);
        }
            st.push(i);
        }
        return max;
    }
}

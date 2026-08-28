 class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {

            while (!st.isEmpty() &&
                  ((i == n) || (heights[st.peek()] > heights[i]))) {

                int h = heights[st.pop()];
                int right = i;

                int left;

                if (st.isEmpty()) {
                    left = -1;
                } 
                else {
                    left = st.peek();
                }

                int width = right - left - 1;

                max = Math.max(max, width * h);
            }

            if (i < n) {
                st.push(i);
            }
        }

        return max;
    }
}
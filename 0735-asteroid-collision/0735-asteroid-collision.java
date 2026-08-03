class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int x : asteroids) {

            while (!st.isEmpty() && st.peek() > 0 && x < 0) {

                int top = st.pop();

                if (Math.abs(top) == Math.abs(x)) {
                    x = 0;
                    break;
                }
                else if (Math.abs(top) > Math.abs(x)) {
                    x = top;
                    break;
                }
                // else:
                // current asteroid survives, continue checking
            }

            if (x != 0) {
                st.push(x);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}
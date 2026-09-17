class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        boolean[] present = new boolean[100001];

        for (int x : nums) {
            if (x % k == 0) {
                present[x / k] = true;
            }
        }

        for (int i = 1; i < present.length; i++) {
            if (!present[i]) {
                return i * k;
            }
        }

        return -1;
    
    }
}
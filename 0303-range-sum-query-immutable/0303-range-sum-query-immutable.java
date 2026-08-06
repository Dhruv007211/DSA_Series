class NumArray {

    int[] pref;

    public NumArray(int[] nums) {

        pref = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return pref[right + 1] - pref[left];
    }
}
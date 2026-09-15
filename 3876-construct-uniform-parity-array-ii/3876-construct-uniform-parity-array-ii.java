class Solution {
    public boolean uniformArray(int[] nums1) {

        Arrays.sort(nums1);

        if (nums1[0] % 2 == 1)
            return true;

        for (int x : nums1) {
            if (x % 2 == 1)
                return false;
        }

        return true;
    }
}
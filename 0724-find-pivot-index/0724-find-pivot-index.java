class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        int left=0;
        for(int n:nums){
            total+=n;

        }
        for(int i=0;i<nums.length;i++){
            int right=total-nums[i]-left;
            if(left==right)return i;
            left+=nums[i];
        }
        return -1;
    }
}
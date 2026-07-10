class Solution {
    public int pivotIndex(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];}
            int l=0;
            for(int i=0;i<nums.length;i++){
                int r=total-l-nums[i];
                if(r==l)return i;
                l+=nums[i];
            }
            return -1;}}
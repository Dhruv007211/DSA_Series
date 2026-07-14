class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int h=nums.length-1;
        while(low<=h){
            int mid=low+(h-low)/2;
            if(nums[mid]==target)return mid;
            if(nums[low]<=nums[mid]){
                if(target>=nums[low]&&target<nums[mid]){
                    h=mid-1;

                }
                else{
                    low=mid+1;
                }
            }
            else{
               if(target>nums[mid]&&target<=nums[h]){
                    low=mid+1;

                }
                else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
}
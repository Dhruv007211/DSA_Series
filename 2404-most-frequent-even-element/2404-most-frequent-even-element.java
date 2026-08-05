class Solution {
    public int mostFrequentEven(int[] nums) {
         Arrays.sort(nums);
        int c=0;
        int can=-1;
        int maxFreq=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0)continue;
            
            if(i>0&&nums[i]==nums[i-1])c++;
            else{
                c=1;
            }
             if (c > maxFreq) {
                maxFreq = c;
                can = nums[i];
            }
        }
        return can;
    }
}
    
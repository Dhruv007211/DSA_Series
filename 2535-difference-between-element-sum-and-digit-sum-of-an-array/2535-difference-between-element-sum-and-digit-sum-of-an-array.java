class Solution {
    public int differenceOfSum(int[] nums) {
        int t=0;
        int carr=0;
        for(int i:nums){
            t+=i;
            while(i>0){

            carr+=i%10;
            i=i/10;
        }}
        return Math.abs(t-carr);
    }
}
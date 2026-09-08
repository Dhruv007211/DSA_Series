class Solution {
    public int countCommas(int n) {
        long ans=0;
        if(n>=1000){
            ans+=n-999;
        }
        if(n>=1000000){
            ans+=(long)n-99999;
        }
        if(n>=1000000000){
            ans+=(long)n-99999999;
        }
        return (int)ans;
    }
}
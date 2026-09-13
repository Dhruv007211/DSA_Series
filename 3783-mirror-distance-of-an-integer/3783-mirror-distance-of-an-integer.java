class Solution {
    public int mirrorDistance(int n) {
        int o=n;
        int dig=0;
        while(n>0){
        int rev=n%10;
        dig=dig*10+rev;
        n=n/10;}
        return Math.abs(o-dig);
    }
}
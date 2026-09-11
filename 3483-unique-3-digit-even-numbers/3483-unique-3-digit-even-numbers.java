class Solution {
    public int totalNumbers(int[] digits) {
        int ans=0;
        for(int i=100;i<=998;i+=2){
            int[]f=new int[10];
            for(int d:digits)f[d]++;
            int x=i;
            int c=x%10;
            int b=(x/10)%10;
            int a=x/100;
        
            if (f[a] > 0) f[a]--;
            else continue;

            if (f[b] > 0) f[b]--;
            else continue;

            if (f[c] > 0) ans++;
        }

        return ans;
    }
}
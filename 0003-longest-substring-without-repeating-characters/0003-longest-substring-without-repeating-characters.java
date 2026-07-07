class Solution {
    public int lengthOfLongestSubstring(String s) {
        int last[]=new int [256];
        for(int i=0;i<256;i++){
            last[i]=-1;
        }
        int l=0;
        int max=0;
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            if(last[c]>=l){
                l=last[c]+1;
            }
            last[c]=r;
            max=Math.max(max,r-l+1);
        }
        return max;
        
    }
}
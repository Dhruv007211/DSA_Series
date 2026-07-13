class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        for(int i=0;i<=n-m;i++){
            boolean f=true;
            for(int j=0;j<m;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                f=false;
                break;}}
            if(f)return i;
         
        }
        
        return -1;
        
    }
}
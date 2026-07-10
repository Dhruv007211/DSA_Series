class Solution {
    public int characterReplacement(String s, int k) {
     
      int ans=0;
      int i=0;
      int f[]=new int[26];
      int max=0;
      for(int j=0;j<s.length();j++){
        f[s.charAt(j)-'A']++;
        max=Math.max(max, f[s.charAt(j)-'A']);
       while((j-i+1)-max>k){
 f[s.charAt(i)-'A']--;
 i++;}

        ans=Math.max(ans,j-i+1);
      }
      return ans;}}
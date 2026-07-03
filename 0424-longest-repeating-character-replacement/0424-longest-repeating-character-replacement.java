class Solution {
    public int characterReplacement(String s, int k) {
     int left=0;
      int max=0;
      int f[]=new int[26];
      int ans=0;
      for(int i=0;i<s.length();i++){
        f[s.charAt(i)-'A']++;
        max=Math.max(max, f[s.charAt(i)-'A']);
        while((i-left+1)-max>k){
             f[s.charAt(left)-'A']--;
             left++;
        }
        ans=Math.max(ans,i-left+1);
      }
      return ans;}}
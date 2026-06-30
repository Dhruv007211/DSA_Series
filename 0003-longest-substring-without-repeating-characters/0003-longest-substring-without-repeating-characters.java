class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set=new HashSet<>();
        int left=0; int max=0;
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            while(set.contains(c)){
              set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
 max= Math.max(max, r - left + 1);
        }
        return max;
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder rev=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                rev.append(Character.toLowerCase(c));
            }
        }
     
        String str = rev.toString();
        String re = rev.reverse().toString();
        return str.equals(re);
    }
}
// Time Com
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // int map=new int[26];
        for(int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i)))return false;
        }
        return true;
    }
}
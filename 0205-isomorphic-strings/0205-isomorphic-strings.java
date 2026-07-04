class Solution {
    public boolean isIsomorphic(String s, String t) {
       HashMap<Character,Character>map1=new HashMap<>();
        HashMap<Character,Character>map2=new HashMap<>();
        for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        char y=t.charAt(i);
        if(map1.containsKey(c)&&map1.get(c)!=y)return false;
        if(map2.containsKey(y)&&map2.get(y)!=c)return false;
        map1.put(c,y);
        map2.put(y,c);
        }
        return true;
    }
}
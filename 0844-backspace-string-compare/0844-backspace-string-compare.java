class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>s1=new Stack<>();
             Stack<Character>s2=new Stack<>();
        for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
            if (ch != '#') {
                s1.push(ch);
            } else if (!s1.isEmpty()) {
                s1.pop();
            }
        }
         for(int i=0;i<t.length();i++){
           char ch=t.charAt(i);
            if (ch != '#') {
                s2.push(ch);
            } else if (!s2.isEmpty()) {
                s2.pop();
            }
        
        }
        return s1.equals(s2)  ;
    }
}
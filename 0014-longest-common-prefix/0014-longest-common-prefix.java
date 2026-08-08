class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null)return "";
       String pre=strs[0];
       for(int i=0;i<strs.length;i++){
       while(!strs[i].startsWith(pre)) {
            pre=pre.substring(0,pre.length()-1);
        }}
        return pre;
       }
       }
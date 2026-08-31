class Solution {
    public String minWindow(String s, String t) {
        int need[]=new int [128];
        for(char c:t.toCharArray()){
            need[c]++;
        }
        int start=0;
        int left=0;
        int min=Integer.MAX_VALUE;
        int count=t.length();
for(int r=0;r<s.length();r++){
       char c1=s.charAt(r);
    if(need[c1]>0)count--;
    need[c1]--;
    while(count==0){
        if(r-left+1<min){
            min=r-left+1;
            start=left;
        }
        char c=s.charAt(left);
          need[c]++;
        if(need[c]>0)count++;
        left++;
    }
}
return min==Integer.MAX_VALUE?"":s.substring(start,start+min);
    }
}
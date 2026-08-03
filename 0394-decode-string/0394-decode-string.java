class Solution {
    public String decodeString(String s) {
        Stack<Integer>num=new Stack<>();
        Stack<String>str=new Stack<>();
        int nums=0;
        String curr="";
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
              nums=nums*10+(ch-'0');
            }
            else if(ch=='['){
                num.push(nums);
                str.push(curr);
                nums=0;
                curr="";
            }
            else if(ch==']'){
                int r=num.pop();
                String prev=str.pop();
                String ans=prev;
                while(r>0){
                    ans+=curr;
                    r--;
                }
                curr=ans;
            }
            else{
                curr+=ch;
            }}
            return curr;
        
    }
}
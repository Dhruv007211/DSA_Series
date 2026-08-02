class Solution {
    public int evalRPN(String[] tokens) {
     Stack<Integer>st=new Stack<>();
        for(String ch:tokens){
            if(!ch.equals("+")&&!ch.equals("*")&&!ch.equals("-")&&!ch.equals("/")&&!ch.equals("^")){
                st.push(Integer.parseInt(ch));
            }
            else{
                int a=st.pop();
                int b=st.pop();
                switch(ch){
                    case "+":
                    st.push(b+a);
                    break;
                    case "-":
                    st.push(b-a);
                    break;
                    case "*":
                    st.push(b*a);
                    break;
                    case "/":
                    st.push(b/a);
                    break;
                }
            }
        }
        return st.peek();
    }
}
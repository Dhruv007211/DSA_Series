class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        solve("",0,0,n,ans);
        return ans;
    }
    void solve(String curr,int o,int c,int n,List<String> ans){
        if(curr.length()==2*n){
            ans.add(curr);
            return ;
        }
        if(o<n){
            solve(curr+"(",o+1,c,n,ans);
        }
        if(c<o){
              solve(curr+")",o,c+1,n,ans);
        }
    }
}
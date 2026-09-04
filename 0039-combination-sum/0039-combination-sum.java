class Solution {
  List<List<Integer>>curr=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      
    // public ArrayList<ArrayList<Integer>> targetSumComb(int[] candidates, int target) {
        // code here
        solve(candidates,target,0,new ArrayList<>());
        return curr;
    }
    void solve(int candidates[],int target,int idx,List<Integer>ans){
        if(target==0){
            curr.add(new ArrayList<>(ans));
            return ;
        }
     
        for(int i=idx;i<candidates.length;i++){
        // solve(candidates,target,idx+1,ans);
           if(target<candidates[i])continue;
        ans.add(candidates[i]);
        solve(candidates,target-candidates[i],i,ans);
        ans.remove(ans.size()-1);
    }
}}
class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer>tem=new ArrayList<>();
        gen(1,n,k,tem);
        return ans;
    }
    void gen(int curr,int n,int k, List<Integer> tem ){
        if(curr>n){
            if(tem.size()==k){
                ans.add(new ArrayList<>(tem));
            }
            return ;
        }
            tem.add(curr);
            gen(curr+1,n,k,tem);
            tem.remove(tem.size()-1);
            gen(curr+1,n,k,tem);
        
    }
}
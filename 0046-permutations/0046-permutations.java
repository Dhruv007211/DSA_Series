class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        perm(nums,new ArrayList<>());
        return ans;
    }
    private void perm(int nums[],List<Integer>curr){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(curr.contains(nums[i]))continue;
            curr.add(nums[i]);
            perm(nums,curr);
            curr.remove(curr.size()-1);
        }
    }
}
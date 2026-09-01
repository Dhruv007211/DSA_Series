class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int m=0;m<(1<<nums.length);m++){
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if((m&(1<<i))!=0){
                    temp.add(nums[i]);
                }
            }
            ans.add(temp);

        }
        return ans;
    }
}
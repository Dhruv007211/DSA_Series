class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer>t=new ArrayList<>();
        t.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                t.add(nums[i]);
            }
            }
             for(int i=0;i<t.size();i++){ 
                nums[i]=t.get(i);
        }
        return t.size();
    }
}
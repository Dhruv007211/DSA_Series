
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        int min = nums[0];
        int max = nums[0];
        HashSet<Integer> set = new HashSet<>();

        // Find min/max and add all elements to a hash set for O(1) lookups
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
            set.add(num);
        }

        // Check every number in the range; if it's not in the set, it's missing
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}
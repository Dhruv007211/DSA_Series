class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> d = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // Window ke bahar wala index remove
            while (!d.isEmpty() && d.peekFirst() <= i - k) {
                d.pollFirst();
            }

            // Chhote elements remove
            while (!d.isEmpty() && nums[d.peekLast()] <= nums[i]) {
                d.pollLast();
            }

            // Index add karo
            d.addLast(i);

            if (i >= k - 1) {

                // Front par maximum ka index
                ans.add(nums[d.peekFirst()]);
            }
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
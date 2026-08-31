 class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int r = 0; r < fruits.length; r++){

            // Add right fruit
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            // More than 2 different fruits
            while(map.size() > 2){

                // Remove left fruit
                map.put(fruits[left], map.get(fruits[left]) - 1);

                // If frequency becomes 0, remove fruit type
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }

                left++;
            }

            // Valid window
            ans = Math.max(ans, r - left + 1);
        }

        return ans;
    }
}
/*
═══════════════════════════════════════════════════════════════
📅 DAY 6
📚 TOPIC : ARRAYS + PREFIX SUM + HASHING

❓ Ques 14.) Subarray Sum Equals K

Problem Statement:

Given an integer array nums and an integer k.

Return the total number of continuous subarrays
whose sum equals k.

Example:

Input:

nums = [1,1,1]
k = 2

Output:

2

Explanation:

Subarrays are:

[1,1]
[1,1]

Total Count = 2

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Generate all possible subarrays.
2. Calculate sum of each subarray.
3. If sum equals k:
      increase count.
4. Return count.

Dry Run:

nums = [1,1,1]

k = 2

Subarrays:

[1]      → 1
[1,1]    → 2 ✅
[1,1,1]  → 3

[1]      → 1
[1,1]    → 2 ✅

[1]      → 1

Answer = 2

Time Complexity  : O(N²)
Space Complexity : O(1)

Pattern Used:
→ Subarray Generation
→ Nested Loops

═══════════════════════════════════════════════════════════════
*/

class SubarraySumKBrute {

    public int subarraySum(int[] nums, int k) {

        int count = 0;

        for(int i = 0; i < nums.length; i++) {

            int sum = 0;

            for(int j = i; j < nums.length; j++) {

                sum += nums[j];

                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Prefix Sum + HashMap)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Subarray Sum = K

Suppose:

Current Prefix Sum = sum

We need:

sum - oldPrefix = k

Therefore:

oldPrefix = sum - k

If (sum - k) already exists,
then a valid subarray is found.

Store frequency of prefix sums in HashMap.

═══════════════════════════════════════════════════════════════

Formula:

sum - oldPrefix = k

oldPrefix = sum - k

═══════════════════════════════════════════════════════════════

Dry Run:

nums = [1,1,1]

k = 2

Map:

{0=1}

--------------------------------

num = 1

sum = 1

Need:

1 - 2 = -1

Not Found

Store:

1 → 1

--------------------------------

num = 1

sum = 2

Need:

2 - 2 = 0

Found

Count += 1

count = 1

Store:

2 → 1

--------------------------------

num = 1

sum = 3

Need:

3 - 2 = 1

Found

Count += 1

count = 2

Answer = 2

═══════════════════════════════════════════════════════════════

Time Complexity  : O(N)

Space Complexity : O(N)

Pattern Used:
→ Prefix Sum
→ HashMap
→ Frequency Counting

Why Optimal?

Each element is processed only once.

HashMap lookup takes O(1).

═══════════════════════════════════════════════════════════════
*/

import java.util.HashMap;

class SubarraySumKOptimal {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0,1);

        int sum = 0;
        int count = 0;

        for(int num : nums) {

            sum += num;

            if(map.containsKey(sum - k)) {

                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum,0) + 1);
        }

        return count;
    }
}
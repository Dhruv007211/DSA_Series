/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Prefix Sum + HashMap)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Suppose:

prefixSum = current sum

Need:

subarray sum = k

Therefore:

prefixSum - previousPrefix = k

previousPrefix = prefixSum - k

If (prefixSum - k) already exists,
then subarray with sum k exists.

Store first occurrence of every prefix sum.

═══════════════════════════════════════════════════════════════

Dry Run:

arr = [10,5,2,7,1,9]

k = 15

--------------------------------

i = 0

sum = 10

Store:

10 → 0

--------------------------------

i = 1

sum = 15

sum == k

maxLen = 2

Store:

15 → 1

--------------------------------

i = 2

sum = 17

Need:

17 - 15 = 2

Not Found

Store:

17 → 2

--------------------------------

i = 3

sum = 24

Need:

24 - 15 = 9

Not Found

Store:

24 → 3

--------------------------------

i = 4

sum = 25

Need:

25 - 15 = 10

Found at index 0

Length:

4 - 0 = 4

maxLen = 4

Answer = 4

═══════════════════════════════════════════════════════════════

Time Complexity : O(N)

Space Complexity: O(N)

Pattern Used:
→ Prefix Sum
→ HashMap
→ Longest Subarray

Why Optimal?

Each element processed once.

HashMap lookup = O(1)

═══════════════════════════════════════════════════════════════
*/

import java.util.HashMap;

class MaxSubarraySumKOptimal {

    public int longestSubarray(int[] arr, int k) {

        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i < arr.length; i++) {

            sum += arr[i];

            if(sum == k) {
                maxLen = i + 1;
            }

            int rem = sum - k;

            if(map.containsKey(rem)) {

                int len = i - map.get(rem);

                maxLen = Math.max(maxLen, len);
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Kadane's Algorithm)
═══════════════════════════════════════════════════════════════

Description:

Observation:

If current sum becomes negative,

it will never help future subarrays.

Why?

Negative sum decreases future total.

Therefore:

Discard negative sum
and start a new subarray.

═══════════════════════════════════════════════════════════════

Algorithm:

1. Maintain currentSum.
2. Add current element.
3. Update maximum answer.
4. If currentSum < 0:
      currentSum = 0

═══════════════════════════════════════════════════════════════

Dry Run:

nums = [-2,1,-3,4,-1,2,1,-5,4]

--------------------------------

num = -2

currentSum = -2

maxSum = -2

currentSum < 0

currentSum = 0

--------------------------------

num = 1

currentSum = 1

maxSum = 1

--------------------------------

num = -3

currentSum = -2

currentSum = 0

--------------------------------

num = 4

currentSum = 4

maxSum = 4

--------------------------------

num = -1

currentSum = 3

--------------------------------

num = 2

currentSum = 5

maxSum = 5

--------------------------------

num = 1

currentSum = 6

maxSum = 6

--------------------------------

Answer = 6

═══════════════════════════════════════════════════════════════

Time Complexity : O(N)

Space Complexity: O(1)

Pattern Used:
→ Kadane's Algorithm
→ Running Sum

Why Optimal?

Single Traversal

No extra space

═══════════════════════════════════════════════════════════════
*/

class MaximumSubarrayOptimal {

    public int maxSubArray(int[] nums) {

        int currentSum = 0;

        int maxSum = Integer.MIN_VALUE;

        for(int num : nums) {

            currentSum += num;

            maxSum = Math.max(maxSum, currentSum);

            if(currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}

/*
═══════════════════════════════════════════════════════════════
📅 DAY 4
📚 TOPIC : ARRAYS & PREFIX SUM

❓ Ques 9.) Running Sum of 1D Array

Problem Statement:

Given an array nums.

Return the running sum of nums.

Running Sum:

runningSum[i] =
nums[0] + nums[1] + ... + nums[i]

Example:

Input:
nums = [1,2,3,4]

Output:
[1,3,6,10]

Explanation:

1
1+2 = 3
1+2+3 = 6
1+2+3+4 = 10

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

For every index:

1. Start sum = 0
2. Traverse from 0 to i
3. Calculate cumulative sum
4. Store answer

Dry Run:

nums = [1,2,3,4]

i = 0

sum = 1

ans = [1]

--------------------------------

i = 1

sum = 1+2

ans = [1,3]

--------------------------------

i = 2

sum = 1+2+3

ans = [1,3,6]

--------------------------------

i = 3

sum = 1+2+3+4

ans = [1,3,6,10]

Time Complexity  : O(N²)
Space Complexity : O(N)

Pattern Used:
→ Nested Loops
→ Prefix Calculation

═══════════════════════════════════════════════════════════════
*/

class RunningSumBrute {

    public int[] runningSum(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {

            int sum = 0;

            for(int j = 0; j <= i; j++) {

                sum += nums[j];
            }

            ans[i] = sum;
        }

        return ans;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Prefix Sum)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Current running sum

=
Previous running sum
+
Current element

Formula:

runningSum[i]
=
runningSum[i-1] + nums[i]

Steps:

1. Start from index 1
2. Add previous value into current value
3. Store result in same array

Dry Run:

nums = [1,2,3,4]

i = 1

nums[1] = 2 + 1

nums = [1,3,3,4]

--------------------------------

i = 2

nums[2] = 3 + 3

nums = [1,3,6,4]

--------------------------------

i = 3

nums[3] = 4 + 6

nums = [1,3,6,10]

Answer:
[1,3,6,10]

Time Complexity  : O(N)

Space Complexity : O(1)

Pattern Used:
→ Prefix Sum
→ Cumulative Sum

Why Optimal?

Each element visited only once.

No extra traversal required.

═══════════════════════════════════════════════════════════════
*/

class RunningSumOptimal {

    public int[] runningSum(int[] nums) {

        for(int i = 1; i < nums.length; i++) {

            nums[i] = nums[i] + nums[i - 1];
        }

        return nums;
    }
}
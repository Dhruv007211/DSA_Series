/*
═══════════════════════════════════════════════════════════════
📅 DAY 5
📚 TOPIC : ARRAYS & PREFIX SUM

❓ Ques 10.) Find Pivot Index

Problem Statement:

Given an array nums.

Return the pivot index.

Pivot Index:

An index where

Sum of all elements on left side
=
Sum of all elements on right side

If no pivot index exists,
return -1.

Example:

Input:
nums = [1,7,3,6,5,6]

Output:
3

Explanation:

Left Sum  = 1+7+3 = 11

Right Sum = 5+6 = 11

Therefore,
Pivot Index = 3

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

For every index:

1. Calculate left sum
2. Calculate right sum
3. Compare both sums
4. If equal:
      return current index

Dry Run:

nums = [1,7,3,6,5,6]

i = 3

Left Sum:

1+7+3 = 11

Right Sum:

5+6 = 11

Left == Right ✅

Return 3

Time Complexity  : O(N²)
Space Complexity : O(1)

Pattern Used:
→ Nested Loops
→ Left Sum & Right Sum Calculation

═══════════════════════════════════════════════════════════════
*/

class PivotIndexBrute {

    public int pivotIndex(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n; i++) {

            int leftSum = 0;
            int rightSum = 0;

            for(int j = 0; j < i; j++) {
                leftSum += nums[j];
            }

            for(int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }

            if(leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Prefix Sum)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Right Sum

=
Total Sum
-
Current Element
-
Left Sum

Formula:

rightSum = totalSum - nums[i] - leftSum

Steps:

1. Find total sum of array.
2. Initialize leftSum = 0.
3. Traverse array.
4. Calculate rightSum.
5. If leftSum == rightSum:
      return current index.
6. Update leftSum.

Dry Run:

nums = [1,7,3,6,5,6]

Total Sum = 28

--------------------------------

i = 0

leftSum = 0

rightSum = 28 - 1 - 0 = 27

Not Equal

Update leftSum = 1

--------------------------------

i = 1

leftSum = 1

rightSum = 28 - 7 - 1 = 20

Not Equal

Update leftSum = 8

--------------------------------

i = 2

leftSum = 8

rightSum = 28 - 3 - 8 = 17

Not Equal

Update leftSum = 11

--------------------------------

i = 3

leftSum = 11

rightSum = 28 - 6 - 11 = 11

Equal ✅

Return 3

Time Complexity  : O(N)

Space Complexity : O(1)

Pattern Used:
→ Prefix Sum
→ Running Sum
→ Left Sum / Right Sum

Why Optimal?

No repeated summation.

Only one traversal after finding total sum.

═══════════════════════════════════════════════════════════════
*/

class PivotIndexOptimal {

    public int pivotIndex(int[] nums) {

        int totalSum = 0;

        for(int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - nums[i] - leftSum;

            if(leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}
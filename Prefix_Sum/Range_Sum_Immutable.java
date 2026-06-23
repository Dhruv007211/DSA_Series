/*
═══════════════════════════════════════════════════════════════
📅 DAY 5
📚 TOPIC : ARRAYS & PREFIX SUM

❓ Ques 11.) Range Sum Query

Problem Statement:

Given an integer array nums,
answer multiple queries of the form:

Find sum of elements from index left to right.

Example:

nums = [-2,0,3,-5,2,-1]

Query:

left = 0
right = 2

Output:

1

Explanation:

-2 + 0 + 3 = 1

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

For every query:

1. Start sum = 0
2. Traverse from left to right
3. Add all elements
4. Return sum

Dry Run:

nums = [-2,0,3,-5,2,-1]

left = 0
right = 2

sum = 0

sum += -2

sum += 0

sum += 3

Answer = 1

Time Complexity : O(N) per query
Space Complexity: O(1)

Pattern Used:
→ Simple Traversal

═══════════════════════════════════════════════════════════════
*/

class RangeSumBrute {

    int[] nums;

    public RangeSumBrute(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {

        int sum = 0;

        for(int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Prefix Sum)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Range Sum

=
Prefix[right]
-
Prefix[left-1]

Prefix Array:

prefix[i]
=
sum of elements from index 0 to i

Formula:

sum(left,right)

=
prefix[right]
-
prefix[left-1]

Special Case:

left = 0

Answer = prefix[right]

═══════════════════════════════════════════════════════════════

Dry Run:

nums = [-2,0,3,-5,2,-1]

Prefix Array:

index : 0  1  2  3  4  5

nums  : -2 0  3 -5  2 -1

prefix: -2 -2 1 -4 -2 -3

--------------------------------

Query:

left = 0
right = 2

Answer:

prefix[2]

=

1

--------------------------------

Query:

left = 2
right = 5

Answer:

prefix[5] - prefix[1]

=

(-3) - (-2)

=

-1

Time Complexity :

Construction → O(N)

Each Query → O(1)

Space Complexity :

O(N)

Pattern Used:
→ Prefix Sum
→ Range Query

Why Optimal?

After preprocessing,
every query is answered in O(1).

═══════════════════════════════════════════════════════════════
*/

class NumArray {

    int[] prefix;

    public NumArray(int[] nums) {

        prefix = new int[nums.length];

        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {

            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        if(left == 0) {
            return prefix[right];
        }

        return prefix[right] - prefix[left - 1];
    }
}
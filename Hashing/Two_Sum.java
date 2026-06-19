package Hashing;
/*
═══════════════════════════════════════════════════════════════
📅 DAY 3
📚 TOPIC :  HASHING

❓ Ques 6.) Two Sum

Problem Statement:

Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up
to target.

Example:

Input:
nums = [2,7,11,15]
target = 9

Output:
[0,1]

Explanation:
nums[0] + nums[1] = 2 + 7 = 9

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Check every possible pair.
2. Use two nested loops.
3. If sum of any pair equals target:
      return indices.
4. If no pair found:
      return [-1,-1]

Dry Run:

nums = [2,7,11,15]
target = 9

i=0

j=1

2+7 = 9 ✅

Return [0,1]

Time Complexity  : O(N²)
Space Complexity : O(1)

Pattern Used:
→ Nested Loops
→ Pair Checking

═══════════════════════════════════════════════════════════════
*/

class TwoSumBrute {

  public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++) {

            for(int j = i + 1; j < nums.length; j++) {

                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}

/*
═══════════════════════════════════════════════════════════════
BETTER APPROACH (HashMap)
═══════════════════════════════════════════════════════════════

Description:

Observation:

arr[i] + arr[j] = target

Suppose current number = arr[i]

Then required number:

need = target - arr[i]

If need already exists in HashMap,
then pair is found.

Steps:

1. Create HashMap.
2. Traverse array.
3. Calculate needed value.
4. Check if needed value exists in map.
5. If yes → pair found.
6. Otherwise store current element.

Dry Run:

nums = [2,7,11,15]
target = 9

i=0

num = 2

need = 7

Map = {}

Store:
2 → 0

Map:
{2=0}

--------------------------------

i=1

num = 7

need = 2

Map contains 2 ✅

Return [0,1]

Time Complexity  : O(N)
Space Complexity : O(N)

Pattern Used:
→ Hashing
→ Complement Technique

Why Better?

Instead of searching entire array again,
HashMap gives O(1) lookup.

═══════════════════════════════════════════════════════════════
*/

import java.util.HashMap;

class TwoSumBetter {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int need = target - nums[i];

            if(map.containsKey(need)) {

                return new int[]{map.get(need), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
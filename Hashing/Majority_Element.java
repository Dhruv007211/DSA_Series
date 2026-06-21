/*
═══════════════════════════════════════════════════════════════
📅 DAY 4
📚 TOPIC : ARRAYS & HASHING

❓ Ques 8.) Majority Element

Problem Statement:

Given an array nums of size n,
find the majority element.

The majority element is the element that appears
more than ⌊n/2⌋ times.

You may assume that the majority element always exists.

Example:

Input:
nums = [3,2,3]

Output:
3

--------------------------------

Input:
nums = [2,2,1,1,1,2,2]

Output:
2

Explanation:

2 appears 4 times.
n = 7

4 > 7/2

Therefore,
2 is the majority element.

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Pick every element.
2. Count its frequency.
3. If frequency becomes greater than n/2:
      return that element.
4. Otherwise continue.

Dry Run:

nums = [2,2,1,1,1,2,2]

For element 2:

Count = 4

4 > 7/2

Return 2

Time Complexity  : O(N²)
Space Complexity : O(1)

Pattern Used:
→ Frequency Counting
→ Nested Loops

═══════════════════════════════════════════════════════════════
*/

class MajorityElementBrute {

    public int majorityElement(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n; i++) {

            int count = 0;

            for(int j = 0; j < n; j++) {

                if(nums[i] == nums[j]) {
                    count++;
                }
            }

            if(count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }
}
/*
═══════════════════════════════════════════════════════════════
BETTER APPROACH (HashMap)
═══════════════════════════════════════════════════════════════

Description:

1. Store frequency of every element.
2. Traverse array.
3. Update frequency in HashMap.
4. If frequency exceeds n/2:
      return element.

Dry Run:

nums = [2,2,1,1,1,2,2]

Map:

2 → 4
1 → 3

4 > 7/2

Return 2

Time Complexity  : O(N)
Space Complexity : O(N)

Pattern Used:
→ Hashing
→ Frequency Counting

═══════════════════════════════════════════════════════════════
*/

import java.util.HashMap;

class MajorityElementBetter {

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for(int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);

            if(map.get(num) > n / 2) {
                return num;
            }
        }

        return -1;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Moore's Voting Algorithm)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Majority Element frequency > n/2

This means:

Even if every other element tries to cancel it,
the majority element will still survive.

Idea:

1. Keep a candidate.
2. Keep a count.
3. If count becomes 0:
      choose current element as candidate.
4. If current element equals candidate:
      count++
5. Otherwise:
      count--

At the end,
candidate will be the majority element.

Dry Run:

nums = [2,2,1,1,1,2,2]

candidate = 2
count = 1

2 -> count = 2

1 -> count = 1

1 -> count = 0

1 -> candidate = 1
count = 1

2 -> count = 0

2 -> candidate = 2
count = 1

Answer = 2

Time Complexity  : O(N)
Space Complexity : O(1)

Pattern Used:
→ Moore's Voting Algorithm
→ Cancellation Technique

Why Optimal?

No extra HashMap.
Only one traversal.
Constant space.

═══════════════════════════════════════════════════════════════
*/

class MajorityElementOptimal {

    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for(int num : nums) {

            if(count == 0) {
                candidate = num;
            }

            if(num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
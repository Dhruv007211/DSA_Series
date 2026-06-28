package Hashing;
/*
═══════════════════════════════════════════════════════════════
📅 DAY 3
📚 TOPIC : HASHING

❓ Ques 7.) Contains Duplicate

Problem Statement:

Given an integer array nums,
return true if any value appears at least twice,
and return false if every element is distinct.

Example:

Input:
nums = [1,2,3,1]

Output:
true

Explanation:
1 appears more than once.

--------------------------------

Input:
nums = [1,2,3,4]

Output:
false

Explanation:
All elements are unique.

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Compare every element with every other element.
2. Use two nested loops.
3. If any two elements are equal:
      return true.
4. If no duplicate found:
      return false.

Dry Run:

nums = [1,2,3,1]

i = 0

j = 1

1 == 2 ❌

j = 2

1 == 3 ❌

j = 3

1 == 1 ✅

Return true

Time Complexity  : O(N²)
Space Complexity : O(1)

Pattern Used:
→ Nested Loops
→ Pair Comparison

Drawback:

For every element,
we again scan remaining array.

Not efficient for large inputs.

═══════════════════════════════════════════════════════════════
*/

class ContainsDuplicateBrute {

    public boolean checkDuplicates(int arr[]) {

        int n = arr.length;

        for(int i = 0; i < n; i++) {

            for(int j = i + 1; j < n; j++) {

                if(arr[i] == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (HashSet)
═══════════════════════════════════════════════════════════════

Description:

Observation:

HashSet stores only unique values.

If current element already exists
in HashSet,

then duplicate is found.

Steps:

1. Create HashSet.
2. Traverse array.
3. Check if element already exists.
4. If yes:
      return true.
5. Otherwise add element.
6. If traversal completes:
      return false.

Dry Run:

nums = [1,2,3,1]

Set = {}

--------------------------------

num = 1

Add 1

Set = {1}

--------------------------------

num = 2

Add 2

Set = {1,2}

--------------------------------

num = 3

Add 3

Set = {1,2,3}

--------------------------------

num = 1

Already Present ✅

Return true

═══════════════════════════════════════════════════════════════

Time Complexity : O(N)

Space Complexity : O(N)

Pattern Used:
→ Hashing
→ HashSet
→ Duplicate Detection

Why Optimal?

HashSet lookup is O(1).

No need to compare every pair.

═══════════════════════════════════════════════════════════════
*/

import java.util.HashSet;

class ContainsDuplicateOptimal {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {

            if(set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}
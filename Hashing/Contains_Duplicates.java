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
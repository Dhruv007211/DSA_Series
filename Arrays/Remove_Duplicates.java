import java.util.LinkedHashSet;

/*
═══════════════════════════════════════════════════════════════
📅 DAY 3
📚 TOPIC : ARRAYS 

❓ Ques 5.) Remove Duplicates from Sorted Array

Problem Statement:
Given a sorted array nums, remove the duplicates in-place
such that each unique element appears only once.

Return the number of unique elements.

Example:

Input  : [1,1,2]
Output : 2

Array becomes:
[1,2,_]

Input  : [0,0,1,1,1,2,2,3,3,4]
Output : 5

Array becomes:
[0,1,2,3,4,_,_,_,_,_]

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH (Using LinkedHashSet)
═══════════════════════════════════════════════════════════════

Description:

1. Create a LinkedHashSet.
2. Insert all elements into the set.
3. Duplicate elements are automatically removed.
4. Copy elements back into the array.
5. Return size of set.

Why LinkedHashSet?
→ Removes duplicates.
→ Maintains insertion order.

Dry Run:

nums = [1,1,2,2,3]

Set = [1,2,3]

Copy back:

nums = [1,2,3,_,_]

Answer = 3

Time Complexity  : O(N)
Space Complexity : O(N)

═══════════════════════════════════════════════════════════════
*/

class RemoveDuplicatesBrute {

    public int removeDuplicates(int[] nums) {

        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int i = 0;

        for (int n : set) {
            nums[i] = n;
            i++;
        }

        return set.size();
    }
}

/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Two Pointers)
═══════════════════════════════════════════════════════════════

Description:

Since array is already sorted:

1. First element is always unique.
2. Use pointer k to track position of last unique element.
3. Traverse array from index 1.
4. Whenever current element differs from previous element:
      increment k
      place current element at nums[k]
5. Return k + 1.

Dry Run:

nums = [1,1,2,2,3]

k = 0

i = 1
1 == 1
Ignore

i = 2
2 != 1

k = 1
nums[1] = 2

Array:
[1,2,2,2,3]

i = 4
3 != 2

k = 2
nums[2] = 3

Array:
[1,2,3,2,3]

Unique Elements = 3

Answer = 3

Time Complexity  : O(N)
Space Complexity : O(1)

Why Optimal?
→ No extra data structure used.
→ In-place modification.
→ Best possible space complexity.

Pattern Used:
→ Two Pointers

═══════════════════════════════════════════════════════════════
*/

class RemoveDuplicatesOptimal {

    public int removeDuplicates(int[] nums) {

        int k = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {

                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1;
    }
}
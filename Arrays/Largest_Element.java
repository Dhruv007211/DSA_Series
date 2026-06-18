import java.util.Arrays;

/*
═══════════════════════════════════════════════════════════════
📅 DAY 1
📚 TOPIC : ARRAYS

❓ Ques 1.) Largest Element in an Array

Problem Statement:
Given an array arr[], find and return the largest element.

Example:
Input  : [1, 8, 7, 56, 90]
Output : 90

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH (Sorting)
═══════════════════════════════════════════════════════════════

Description:
1. Sort the array in ascending order.
2. The last element will be the largest element.
3. Return arr[n-1].

Dry Run:
arr = [1, 8, 7, 56, 90]

After Sorting:
[1, 7, 8, 56, 90]

Largest = 90

Time Complexity  : O(N log N)
Space Complexity : O(1)

═══════════════════════════════════════════════════════════════
*/

class LargestElement {

    public static int largestBrute(int[] arr) {

        Arrays.sort(arr);

        return arr[arr.length - 1];
    }
}

/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Single Traversal)
═══════════════════════════════════════════════════════════════

Description:
1. Assume first element is largest.
2. Traverse the array once.
3. Update max whenever a larger element is found.
4. Return max.

Dry Run:
arr = [1, 8, 7, 56, 90]

max = 1

8 > 1  → max = 8
7 > 8  → No
56 > 8 → max = 56
90 > 56 → max = 90

Answer = 90

Time Complexity  : O(N)
Space Complexity : O(1)

Why Optimal?
→ No sorting required.
→ Only one traversal.
→ Best possible time complexity.

═══════════════════════════════════════════════════════════════
*/

class LargestElementOptimal {

    public static int largestOptimal(int[] arr) {

        int max = arr[0];

        for (int num : arr) {

            if (num > max) {
                max = num;
            }
        }

        return max;
    }
}
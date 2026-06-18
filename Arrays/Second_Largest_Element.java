import java.util.Arrays;

/*
═══════════════════════════════════════════════════════════════
📅 DAY 1
📚 TOPIC : ARRAYS 

❓ Ques 2.) Second Largest Element in an Array

Problem Statement:
Given an array arr[], find the second largest distinct element.
If no such element exists, return -1.

Example:
Input  : [12, 35, 1, 10, 34, 1]
Output : 34

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH (Sorting)
═══════════════════════════════════════════════════════════════

Description:
1. Sort the array.
2. Largest element will be at last index.
3. Traverse from n-2 towards left.
4. First element different from largest is answer.

Dry Run:

arr = [12,35,1,10,34,1]

After Sorting:

[1,1,10,12,34,35]

Largest = 35

34 != 35

Answer = 34

Time Complexity  : O(N log N)
Space Complexity : O(1)

═══════════════════════════════════════════════════════════════
*/

class SecondLargestBrute {

    public static int getSecondLargest(int[] arr) {

        Arrays.sort(arr);

        int largest = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {

            if (arr[i] != largest) {
                return arr[i];
            }
        }

        return -1;
    }
}

/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Single Traversal)
═══════════════════════════════════════════════════════════════

Description:
1. Maintain largest and secondLargest.
2. Update largest whenever bigger element found.
3. Previous largest becomes secondLargest.
4. Return secondLargest.

Dry Run:

arr = [12,35,1,10,34]

largest = -1
secondLargest = -1

12 -> largest = 12

35 -> secondLargest = 12
      largest = 35

1  -> Ignore

10 -> Ignore

34 -> secondLargest = 34

Answer = 34

Time Complexity  : O(N)
Space Complexity : O(1)

Why Optimal?
→ No sorting required.
→ Single traversal.
→ Best possible solution.

═══════════════════════════════════════════════════════════════
*/

class SecondLargestOptimal {

    public static int getSecondLargest(int[] arr) {

        int largest = -1;
        int secondLargest = -1;

        for (int num : arr) {

            if (num > largest) {

                secondLargest = largest;
                largest = num;
            }

            else if (num > secondLargest &&
                     num != largest) {

                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
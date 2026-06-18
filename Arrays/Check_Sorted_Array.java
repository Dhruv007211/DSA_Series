/*
═══════════════════════════════════════════════════════════════
📅 DAY 2
📚 TOPIC : ARRAYS 

❓ Ques 3.) Check if Array is Sorted

Problem Statement:
Check whether an array is sorted in non-decreasing order.

Example:

Input  : [1,2,3,4]
Output : true

Input  : [1,5,3]
Output : false

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:
Compare every element with every element after it.

If any previous element is greater than a later element,
array is not sorted.

Time Complexity  : O(N²)
Space Complexity : O(1)

═══════════════════════════════════════════════════════════════
*/

class CheckSortedBrute {

    public static boolean isSorted(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] > arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }
}

/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH
═══════════════════════════════════════════════════════════════

Description:
Compare adjacent elements only.

If:
arr[i] > arr[i+1]

Array is not sorted.

Time Complexity  : O(N)
Space Complexity : O(1)

═══════════════════════════════════════════════════════════════
*/

class CheckSortedOptimal {

    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
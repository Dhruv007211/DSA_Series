/*
═══════════════════════════════════════════════════════════════
📅 DAY 2
📚 TOPIC : ARRAYS 

❓ Ques 4.) Move Zeroes to End

Problem Statement:
Move all zeroes to the end while maintaining
relative order of non-zero elements.

Example:

Input  : [1,0,2,0,3]
Output : [1,2,3,0,0]

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:
1. Create temporary array.
2. Copy all non-zero elements.
3. Fill remaining positions with zero.
4. Copy temp back to original array.

Time Complexity  : O(N)
Space Complexity : O(N)

═══════════════════════════════════════════════════════════════
*/

class MoveZeroesBrute {

    public static void pushZerosToEnd(int[] arr) {

        int n = arr.length;

        int[] temp = new int[n];

        int index = 0;

        for (int num : arr) {

            if (num != 0) {
                temp[index++] = num;
            }
        }

        while (index < n) {
            temp[index++] = 0;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }
}

/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Two Pointers)
═══════════════════════════════════════════════════════════════

Description:
i -> position of next non-zero element
j -> traversal pointer

Whenever non-zero found:
swap(arr[i], arr[j])

Time Complexity  : O(N)
Space Complexity : O(1)

═══════════════════════════════════════════════════════════════
*/

class MoveZeroesOptimal {

    public static void pushZerosToEnd(int[] arr) {

        int i = 0;

        for (int j = 0; j < arr.length; j++) {

            if (arr[j] != 0) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }
    }
}
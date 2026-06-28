
 /*
═══════════════════════════════════════════════════════════════
📅 DAY 10
📚 TOPIC : STRINGS

❓ Ques 20.) Reverse String

Problem Statement:

Write a function that reverses a string.

The input string is given as
a character array.

You must reverse the array
in-place using O(1) extra space.

Example:

Input:

['h','e','l','l','o']

Output:

['o','l','l','e','h']

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Create a new character array.
2. Traverse original array from end.
3. Copy characters into new array.
4. Copy new array back to original.

Dry Run:

s = ['h','e','l','l','o']

temp:

['o','l','l','e','h']

Copy back.

Answer:

['o','l','l','e','h']

Time Complexity : O(N)

Space Complexity : O(N)

Pattern Used:
→ Extra Array

═══════════════════════════════════════════════════════════════
*/

class ReverseStringBrute {

    public void reverseString(char[] s) {

        char[] temp = new char[s.length];

        int index = 0;

        for(int i = s.length - 1; i >= 0; i--) {

            temp[index++] = s[i];
        }

        for(int i = 0; i < s.length; i++) {

            s[i] = temp[i];
        }
    }
} {
    
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Two Pointers)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Swap first and last characters.

Move both pointers
towards the center.

Repeat until
left >= right.

═══════════════════════════════════════════════════════════════

Dry Run:

s = ['h','e','l','l','o']

left = 0
right = 4

Swap

h ↔ o

[o,e,l,l,h]

----------------------------

left = 1
right = 3

Swap

e ↔ l

[o,l,l,e,h]

----------------------------

left = 2
right = 2

Stop.

Answer:

[o,l,l,e,h]

═══════════════════════════════════════════════════════════════

Time Complexity : O(N)

Space Complexity : O(1)

Pattern Used:
→ Two Pointers
→ In-place Swapping

Why Optimal?

No extra array required.

Only swapping is performed.

═══════════════════════════════════════════════════════════════
*/

class ReverseStringOptimal {

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while(left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
 /*
═══════════════════════════════════════════════════════════════
📅 DAY 11
📚 TOPIC : STRINGS & HASHING

❓ Ques 22.) Valid Anagram

Problem Statement:

Given two strings s and t.

Return true if t is an anagram of s.

Otherwise return false.

An Anagram means:

Both strings contain exactly
the same characters with
the same frequency.

Example:

Input:

s = "anagram"

t = "nagaram"

Output:

true

Example:

Input:

s = "rat"

t = "car"

Output:

false

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH (Sorting)
═══════════════════════════════════════════════════════════════

Description:

1. If lengths are different,
   return false.

2. Convert both strings
   into character arrays.

3. Sort both arrays.

4. Compare character by character.

5. If all characters match,
   return true.

Otherwise return false.

═══════════════════════════════════════════════════════════════

Dry Run:

s = "cat"

t = "tac"

Convert to char array

[c,a,t]

[t,a,c]

Sort

[a,c,t]

[a,c,t]

Equal

Return true

═══════════════════════════════════════════════════════════════

Time Complexity : O(N log N)

Space Complexity : O(N)

Pattern Used:
→ Sorting
→ Character Array

═══════════════════════════════════════════════════════════════
*/

import java.util.Arrays;

class ValidAnagramBrute {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Frequency Count)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Anagrams have

Same characters

Same frequency

Create an array of size 26.

Increase frequency
for first string.

Decrease frequency
for second string.

Finally,

if every frequency becomes zero,

strings are anagrams.

═══════════════════════════════════════════════════════════════

Dry Run:

s = "anagram"

t = "nagaram"

Frequency Array

Initially

[0 0 0 0 ...]

Read s

a++

n++

a++

g++

...

Read t

n--

a--

g--

...

Finally

All values = 0

Return true

═══════════════════════════════════════════════════════════════

Time Complexity : O(N)

Space Complexity : O(1)

Pattern Used:
→ Hashing
→ Frequency Array

Why Optimal?

Only one traversal.

No sorting required.

═══════════════════════════════════════════════════════════════
*/

class ValidAnagramOptimal {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;

            freq[t.charAt(i) - 'a']--;
        }

        for(int count : freq) {

            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}
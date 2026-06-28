/*
═══════════════════════════════════════════════════════════════
📅 DAY 11
📚 TOPIC : STRINGS & HASHING

❓ Ques 23.) First Unique Character in a String

Problem Statement:

Given a string s,

return the index of the first
non-repeating character.

If every character repeats,
return -1.

Example:

Input:

s = "leetcode"

Output:

0

Explanation:

'l' appears only once.

--------------------------------

Input:

s = "loveleetcode"

Output:

2

Explanation:

'v' is the first unique character.

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

For every character:

1. Count its frequency.
2. If frequency == 1
   return its index.

If no unique character exists,
return -1.

═══════════════════════════════════════════════════════════════

Dry Run:

s = "love"

i = 0

'l'

Frequency = 1

Return 0

═══════════════════════════════════════════════════════════════

Time Complexity : O(N²)

Space Complexity : O(1)

Pattern Used:
→ Nested Loops
→ Frequency Counting

═══════════════════════════════════════════════════════════════
*/

class FirstUniqueCharacterBrute {

    public int firstUniqChar(String s) {

        for(int i = 0; i < s.length(); i++) {

            int count = 0;

            for(int j = 0; j < s.length(); j++) {

                if(s.charAt(i) == s.charAt(j)) {

                    count++;
                }
            }

            if(count == 1) {

                return i;
            }
        }

        return -1;
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Frequency Array)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Need frequency of every character.

Steps:

1. Count frequency of all characters.
2. Traverse string again.
3. Return first character
   whose frequency is 1.

═══════════════════════════════════════════════════════════════

Dry Run:

s = "leetcode"

Pass 1

l → 1

e → 3

t → 1

c → 1

o → 1

d → 1

----------------------------

Pass 2

l

Frequency = 1

Return 0

═══════════════════════════════════════════════════════════════

Time Complexity : O(N)

Space Complexity : O(1)

Pattern Used:
→ Hashing
→ Frequency Array

Why Optimal?

Only two traversals.

Frequency lookup is O(1).

═══════════════════════════════════════════════════════════════
*/

class FirstUniqueCharacterOptimal {

    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {

            if(freq[s.charAt(i) - 'a'] == 1) {

                return i;
            }
        }

        return -1;
    }
}
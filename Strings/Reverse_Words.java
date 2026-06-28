/*
═══════════════════════════════════════════════════════════════
📅 DAY 10
📚 TOPIC : STRINGS

❓ Ques 21.) Reverse Words in a String

Problem Statement:

Given a string s,
reverse the order of words.

Remove extra spaces and
return a single spaced string.

Example:

Input:

s = "the sky is blue"

Output:

"blue is sky the"

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Remove extra spaces.
2. Split the string into words.
3. Traverse words from last to first.
4. Join them with one space.

Dry Run:

Input:

"the sky is blue"

Split:

["the","sky","is","blue"]

Reverse:

blue
is
sky
the

Output:

"blue is sky the"

Time Complexity : O(N)

Space Complexity : O(N)

Pattern Used:
→ Split
→ StringBuilder

═══════════════════════════════════════════════════════════════
*/

class ReverseWordsBrute {

    public String reverseWords(String s) {

        s = s.trim();

        String[] words = s.split("\\s+");

        StringBuilder ans = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--) {

            ans.append(words[i]);

            if(i != 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
/*
═══════════════════════════════════════════════════════════════
OPTIMAL APPROACH (Two Pointers)
═══════════════════════════════════════════════════════════════

Description:

Observation:

Traverse string from right to left.

Whenever a word is found,

append it directly to answer.

No split() is used.

═══════════════════════════════════════════════════════════════

Dry Run:

Input:

"the sky is blue"

Start from end

Word:

blue

Answer:

"blue"

----------------------------

Word:

is

Answer:

"blue is"

----------------------------

Word:

sky

Answer:

"blue is sky"

----------------------------

Word:

the

Answer:

"blue is sky the"

═══════════════════════════════════════════════════════════════

Time Complexity : O(N)

Space Complexity : O(N)

Pattern Used:
→ Two Pointers
→ StringBuilder

Why Optimal?

Only one traversal.

No split() array is created.

═══════════════════════════════════════════════════════════════
*/

class ReverseWordsOptimal {

    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while(i >= 0) {

            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if(i < 0) {
                break;
            }

            int j = i;

            while(j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            ans.append(s.substring(j + 1, i + 1));

            ans.append(" ");

            i = j;
        }

        return ans.toString().trim();
    }
}
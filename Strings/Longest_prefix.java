/*
═══════════════════════════════════════════════════════════════
📅 DAY 12
📚 TOPIC : STRINGS

❓ Ques 24.) Longest Common Prefix

Problem Statement:

Write a function to find the
longest common prefix string
among an array of strings.

If there is no common prefix,
return an empty string.

Example:

Input:

strs = ["flower","flow","flight"]

Output:

"fl"

--------------------------------

Input:

strs = ["dog","racecar","car"]

Output:

""

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH (Character Comparison)
═══════════════════════════════════════════════════════════════

Description:

Take the first string as reference.

Compare each character of the first string
with the corresponding character
of every other string.

If any mismatch occurs,

return prefix till previous character.

If all characters match,

return the first string.

═══════════════════════════════════════════════════════════════

Dry Run:

["flower","flow","flight"]

Reference = "flower"

Compare

f ✓

l ✓

o ✗

Answer = "fl"

═══════════════════════════════════════════════════════════════

Time Complexity : O(N × M)

N = Number of Strings
M = Length of Smallest String

Space Complexity : O(1)

Pattern Used:
→ String Traversal
→ Character Comparison

═══════════════════════════════════════════════════════════════
*/

class LongestCommonPrefix {

    // ---------------- BRUTE FORCE ----------------

    public String longestCommonPrefixBrute(String[] strs) {

        if(strs == null || strs.length == 0)
            return "";

         for (int i = 0; i < strs[0].length(); i++) {

            char ch = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {

                if (i == strs[j].length() ||
                    strs[j].charAt(i) != ch) {

                    return strs[0].substring(0, i);
                }
                return strs[0];
            }
            }
           
            
           
    /*
    ═══════════════════════════════════════════════════════════════
    OPTIMAL APPROACH (Sorting)
    ═══════════════════════════════════════════════════════════════

    Description:

    Observation:

    After sorting,

    only compare

    First String

    and

    Last String

    because they are the
    most different strings.

    Whatever prefix they share,

    every string shares.

    ═══════════════════════════════════════════════════════════════

    Dry Run:

    ["flower","flow","flight"]

    After Sorting

    ["flight","flow","flower"]

    First = "flight"

    Last  = "flower"

    Compare

    f ✓

    l ✓

    i ✗

    Answer = "fl"

    ═══════════════════════════════════════════════════════════════

    Time Complexity :

    Sorting = O(N log N)

    Comparison = O(M)

    Overall ≈ O(N log N)

    Space Complexity : O(1)

    Pattern Used:
    → Sorting
    → String Comparison

    Why Optimal?

    Instead of comparing every string,

    compare only

    First and Last.

    ═══════════════════════════════════════════════════════════════
    */

    public String longestCommonPrefixOptimal(String[] strs) {

        if(strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;

        while(i < first.length() &&
              i < last.length() &&
              first.charAt(i) == last.charAt(i)) {

            i++;
        }

        return first.substring(0, i);
    }
}
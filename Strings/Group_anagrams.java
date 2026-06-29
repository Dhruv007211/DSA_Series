/*
═══════════════════════════════════════════════════════════════
📅 DAY 12
📚 TOPIC : STRINGS & HASHING

❓ Ques 25.) Group Anagrams

Problem Statement:

Given an array of strings strs.

Group all anagrams together.

You can return the answer
in any order.

Example:

Input:

["eat","tea","tan","ate","nat","bat"]

Output:

[
 [eat, tea, ate],
 [tan, nat],
 [bat]
]

Explanation:

Strings having the same
sorted form belong to
the same group.

═══════════════════════════════════════════════════════════════
BRUTE FORCE APPROACH
═══════════════════════════════════════════════════════════════

Description:

1. Traverse every string.
2. Compare it with every other string.
3. Check whether both are anagrams.
4. Group matching strings.

Time Complexity : O(N² × KlogK)

N = Number of Strings
K = Average Length

Space Complexity : O(N)

Pattern Used:
→ Nested Loops
→ Sorting

═══════════════════════════════════════════════════════════════
*/

import java.util.*;

class GroupAnagramsBrute {

    public List<List<String>> groupAnagrams(String[] strs) {

        boolean[] visited = new boolean[strs.length];

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {

            if(visited[i])
                continue;

            List<String> group = new ArrayList<>();

            group.add(strs[i]);

            visited[i] = true;

            for(int j = i + 1; j < strs.length; j++) {

                if(visited[j])
                    continue;

                char[] a = strs[i].toCharArray();
                char[] b = strs[j].toCharArray();

                Arrays.sort(a);
                Arrays.sort(b);

                if(Arrays.equals(a, b)) {

                    group.add(strs[j]);

                    visited[j] = true;
                }
            }

            ans.add(group);
        }

        return ans;
    }
}
class Solution {
    public String minWindow(String s, String t) {

        String ans = "";

        int[] freq = new int[128];

        for(char c : t.toCharArray())
            freq[c]++;

        int j = 0;
        int count = t.length();

        for(int i = 0; i < s.length(); i++){

            if(freq[s.charAt(i)] > 0)
                count--;

            freq[s.charAt(i)]--;

            while(count == 0){

                if(ans.equals("") || ans.length() > (i - j + 1))
                    ans = s.substring(j, i + 1);

                freq[s.charAt(j)]++;

                if(freq[s.charAt(j)] > 0)
                    count++;

                j++;
            }
        }

        return ans;
    }
}
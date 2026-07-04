class Solution {
    public String minWindow(String s, String t) {

        int l = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int count = t.length();

        int need[] = new int[128];

        for(char c : t.toCharArray()){
            need[c]++;
        }

        for(int r = 0; r < s.length(); r++){

            char c = s.charAt(r);

            if(need[c] > 0)
                count--;

            need[c]--;

            while(count == 0){

                if(r - l + 1 < min){
                    min = r - l + 1;
                    start = l;
                }

                c = s.charAt(l);

                need[c]++;

                if(need[c] > 0)
                    count++;

                l++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
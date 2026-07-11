class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map=new HashMap<>();
        for(String str:strs){
        char ch[]=str.toCharArray();
        Arrays.sort(ch);
        String k=new String(ch);
        if(!map.containsKey(k)){
            map.put(k,new ArrayList<>());
        }
        map.get(k).add(str);
    }
    return new ArrayList<>(map.values());
}
}
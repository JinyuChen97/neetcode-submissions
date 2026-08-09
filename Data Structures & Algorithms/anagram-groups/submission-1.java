class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] sa = strs[i].toCharArray();
            Arrays.sort(sa);
            String stringkey = String.valueOf(sa);
            map.putIfAbsent(stringkey,new ArrayList<>());
            map.get(stringkey).add(strs[i]);
        }

        for(List<String> list : map.values()){
            ans.add(list);
        }
        return ans;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> res = new HashMap<>();
        for(String s : strs){
            char[] sa = s.toCharArray();
            Arrays.sort(sa);
            String nsa = new String(sa);
            res.put(nsa, res.getOrDefault(nsa, new ArrayList<>()));
            res.get(nsa).add(s);
        }

        return new ArrayList<>(res.values());
    }
}

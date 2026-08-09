class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int max=0;
        int l=0;
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i)) || map.get(s.charAt(i))<l){
                map.put(s.charAt(i),i);
                max = Math.max(max,i-l+1);
            }else{
                l = map.get(s.charAt(i))+1;
                map.put(s.charAt(i),i);
            }
        }
        return max;
    }
}

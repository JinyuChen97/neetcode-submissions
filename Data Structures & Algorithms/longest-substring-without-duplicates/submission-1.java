class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> check = new HashSet<>();
        int L = 0;
        int R = 0;
        int longest = 0;
        while(R<s.length()){
            if(check.contains(s.charAt(R))){
                check.remove(s.charAt(L));
                L++;
            }else{
                check.add(s.charAt(R));
                longest = Math.max(longest, R-L+1);
                R++;
            }            
        }
        return longest;
    }
}
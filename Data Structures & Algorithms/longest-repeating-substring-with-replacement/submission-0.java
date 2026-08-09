class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> check = new HashMap<>();
        int L = 0;
        int R = 0;
        int maxSameValueAmount = 0;
        int longest = 0;
        while(R<s.length()){
            check.put(s.charAt(R), check.getOrDefault(s.charAt(R),0)+1);
            maxSameValueAmount = Math.max(maxSameValueAmount,check.get(s.charAt(R)));

            while((R-L+1)-maxSameValueAmount>k){
                check.put(s.charAt(L), check.getOrDefault(s.charAt(L),0)-1);
                L++;
            }

            if((R-L+1)-maxSameValueAmount<=k){
                longest = Math.max(longest, R-L+1);
            }
            R++;
        }
        return longest;
    }
}

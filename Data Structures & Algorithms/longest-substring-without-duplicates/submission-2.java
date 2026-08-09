class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l=0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                while(l<i && set.contains(s.charAt(i))){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(i));
            }else{
                set.add(s.charAt(i));
                max=Math.max(max,i-l+1);
            }
        }
        return max;
    }
}

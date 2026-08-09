class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] sa = new int[128];
        Arrays.fill(sa,-1);
        int max=0;
        int l=0;
        for(int i=0;i<s.length();i++){
            if(sa[s.charAt(i)]>=l){
                l=sa[s.charAt(i)]+1;
                sa[s.charAt(i)]=i;
            }
            sa[s.charAt(i)]=i;
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}

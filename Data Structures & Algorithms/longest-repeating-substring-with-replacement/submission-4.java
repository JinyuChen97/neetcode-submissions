class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int max=0;
        int l=0;
        int countFreq=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
            countFreq = Math.max(countFreq,map.get(s.charAt(i)));

            while(i-l+1-countFreq>k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }

            max = Math.max(max,i-l+1);
        }
        return max;
    }
}

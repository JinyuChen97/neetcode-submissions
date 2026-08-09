class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();
        int totalneed = 0;
        int l=0;
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
            totalneed++;
        }

        for(int i=0;i<s2.length();i++){
            if(map.containsKey(s2.charAt(i))&& map.get(s2.charAt(i))>0){
                totalneed--;
            }
            map.put(s2.charAt(i),map.getOrDefault(s2.charAt(i),0)-1);

            if(totalneed==0){
                while(l<s2.length() && map.get(s2.charAt(l))<0){
                    map.put(s2.charAt(l),map.get(s2.charAt(l))+1);
                    l++;
                }
                if(i-l+1 == s1.length()) return true;
            }
        }
        return false;
    }
}

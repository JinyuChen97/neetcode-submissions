class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> check = new HashMap<>();
        for(char s: s1.toCharArray()){
            check.put(s,check.getOrDefault(s,0)+1);
        }

        int need = check.size();
        for(int i = 0; i<s2.length();i++){
            Map<Character,Integer> count = new HashMap<>();
            int current = 0;
            for(int j=i;j<s2.length();j++){
                count.put(s2.charAt(j),count.getOrDefault(s2.charAt(j),0)+1);

                if(check.getOrDefault(s2.charAt(j),0) < count.get(s2.charAt(j))){
                    break;
                }

                if(check.getOrDefault(s2.charAt(j),0) == count.get(s2.charAt(j))){
                    current++;
                }

                if(need == current){
                    return true;
                }
            }
        }
        return false;
    }
}

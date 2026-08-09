class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char kc : t.toCharArray()){
            map.put(kc, map.getOrDefault(kc,0)+1);
        }

        int need = map.size();
        int[] res = {-1,-1};
        int minRes= Integer.MAX_VALUE;
        for(int l=0;l<s.length();l++){
            Map<Character,Integer> current = new HashMap<>();
            for(int r=l;r<s.length();r++){
                current.put(s.charAt(r), current.getOrDefault(s.charAt(r),0)+1);

                boolean flag = true;
                for(char k : map.keySet()){
                    if(current.getOrDefault(k,0)<map.get(k)){
                        flag=false;
                        break;
                    }
                }

                if(flag && r-l+1 < minRes){
                    minRes = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }
            }
        }
        return minRes == Integer.MAX_VALUE?"":s.substring(res[0],res[1]+1);
    }
}

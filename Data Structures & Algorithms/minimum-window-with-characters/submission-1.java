class Solution {
    public String minWindow1(String s, String t) {
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


    public String minWindow(String s, String t) {
        Map<Character,Integer> tMap = new HashMap<>();
        for(char tw: t.toCharArray()){
            tMap.put(tw,tMap.getOrDefault(tw,0)+1);
        }

        int l=0;
        int r=0;
        int need = tMap.size();
        Map<Character,Integer> sMap = new HashMap<>();
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int[] res = {-1,-1};
        while(r<s.length()){
            sMap.put(s.charAt(r),sMap.getOrDefault(s.charAt(r),0)+1);

            if(tMap.containsKey(s.charAt(r)) && sMap.get(s.charAt(r)).equals(tMap.get(s.charAt(r)))){
                count++;
            }


            while(need == count){
                if(r-l+1<minLen){
                    minLen = r-l+1;
                    res[0]=l;
                    res[1]=r;
                }

                sMap.put(s.charAt(l),sMap.get(s.charAt(l))-1);
                if(tMap.containsKey(s.charAt(l)) && sMap.get(s.charAt(l))<tMap.get(s.charAt(l))){
                    count--;
                }
                l++;
            }
            r++;            
        }
        return minLen == Integer.MAX_VALUE? "" : s.substring(res[0],res[1]+1);
    }
}

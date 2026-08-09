class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        int totalNeed=0;
        for(int i=0;i<t.length();i++){
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
            totalNeed++;
        }
        
        int l=0;
        int[] windows = new int[]{0,Integer.MAX_VALUE};
        for(int i=0;i<s.length();i++){
            if(need.containsKey(s.charAt(i))&&need.get(s.charAt(i))>0){
                totalNeed--;
            }
            need.put(s.charAt(i),need.getOrDefault(s.charAt(i),0)-1);

            if(totalNeed==0){
                while(l<s.length() && need.get(s.charAt(l))<0){
                    need.put(s.charAt(l),need.get(s.charAt(l))+1);
                    l++;
                }

                if(i-l<windows[1]-windows[0]){
                    windows[0]=l;
                    windows[1]=i;
                }
                
                need.put(s.charAt(l),need.get(s.charAt(l))+1);
                l++;
                totalNeed++;
            }
        }
        return windows[1]==Integer.MAX_VALUE? "" : s.substring(windows[0],windows[1]+1);
    }
}

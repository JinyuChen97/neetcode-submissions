class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(char sc : s.toCharArray()){
            set.add(sc);
        }

        for(char scc : set){
            int count = 0;
            int l = 0;
            for(int j=0;j<s.length();j++){
                if(scc==s.charAt(j)){
                    count++;
                }

                while(j-l+1-count>k){//如果非法字符已经超出k，那么就缩小窗口
                    if(s.charAt(l)==scc){
                        count--;
                    }
                    l++;
                }

                max=Math.max(max,j-l+1);
            }
        }
        return max;
    }
}

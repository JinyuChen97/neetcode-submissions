class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ans = new int[26];
        for(int i=0;i<s.length();i++){
            char l = s.charAt(i);
            ans[l - 'a'] += 1;
        }

        for(int i=0;i<t.length();i++){
            ans[t.charAt(i) - 'a'] -= 1;
        }

        for(int i=0; i<ans.length;i++){
            if(ans[i]!=0) return false;
        }

        return true;
    }
}

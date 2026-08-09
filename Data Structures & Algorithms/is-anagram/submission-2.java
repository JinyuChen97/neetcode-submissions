class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] check = new char[26];
        for(int i=0;i<t.length();i++){
            check[t.charAt(i)-'a']++; 
        }

        for(int i=0;i<s.length();i++){
            if(check[s.charAt(i)-'a']==0) return false;
            check[s.charAt(i)-'a']--; 
        }
        return true;
    }
}

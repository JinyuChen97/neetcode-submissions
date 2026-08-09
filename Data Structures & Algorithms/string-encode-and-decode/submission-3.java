class Solution {

    public String encode(List<String> strs) {
        if(strs.size()==0) return "";
        StringBuilder sb = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        
        for(int i=0;i<strs.size();i++){
            sizes.add(strs.get(i).length());
            sb.append(strs.get(i).length()).append(',');
        }

        sb.append('#');
        for(String str:strs){
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> sizes = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int i=0;
        while(str.charAt(i)!='#'){
            StringBuilder cur = new StringBuilder();
            while(str.charAt(i)!=','){
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }

        i++;

        for(int s:sizes){
            ans.add(str.substring(i,i+s));
            i+=s;
        }
        return ans;
    }
}

class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();

        for(String s : strs){
            sizes.add(s.length());
        }

        for(Integer size : sizes){
            str.append(size).append(',');
        }

        str.append('#');
        for(String s : strs){
            str.append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0){
            return new ArrayList<>();
        }
        List<Integer> sizes = new ArrayList<>();
        List<String> res = new ArrayList<>();

        int i = 0;
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

        for(int size : sizes){
            res.add(str.substring(i,i+size));
            i+=size;
        }
        return res;
    }
}

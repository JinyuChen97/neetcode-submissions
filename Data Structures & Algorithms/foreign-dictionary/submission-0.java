class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,Set<Character>> adjs = new HashMap<>();
      Map<Character,Integer> indegrees = new HashMap<>();

      for(String word : words){
        for(char w : word.toCharArray()){
            adjs.putIfAbsent(w,new HashSet<>());
            indegrees.putIfAbsent(w, 0);
        }
      }

      for(int i=0;i<words.length-1;i++){
        String w1=words[i];
        String w2=words[i+1];

        int minLen = Math.min(w1.length(),w2.length());

        if(w1.length() > w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))){
            return "";
        }

        for(int k=0;k<minLen;k++){
            char c1 = w1.charAt(k);
            char c2 = w2.charAt(k);
            if(c1!=c2){
                if(!adjs.get(c1).contains(c2)){
                    adjs.get(c1).add(c2);
                    indegrees.put(c2, indegrees.get(c2)+1);
                }
                break;
            }
        }
      }

        Queue<Character> q = new ArrayDeque<>();
        for(char k : indegrees.keySet()){
            if(indegrees.get(k)==0){
                q.offer(k);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            for(char next : adjs.get(curr)){
                indegrees.put(next,indegrees.get(next)-1);
                if(indegrees.get(next)==0){
                    q.offer(next);
                }
            }
        }

        return sb.length()==indegrees.size()? sb.toString():"";
    }
}

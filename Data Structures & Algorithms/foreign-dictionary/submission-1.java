class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character,Set<Character>> adjs = new HashMap<>();//记录char和它要对比的邻居的映射关系
      Map<Character,Integer> indegrees = new HashMap<>();//记录每个char被映射的次数

      for(String word : words){//初始化
        for(char w : word.toCharArray()){
            adjs.putIfAbsent(w,new HashSet<>());
            indegrees.putIfAbsent(w, 0);
        }
      }

      for(int i=0;i<words.length-1;i++){//前后对比两个word
        String w1=words[i];
        String w2=words[i+1];

        int minLen = Math.min(w1.length(),w2.length());//先拿最短的len

        //edges case 如果dict里排前面的反而比排后面的长且 minLen部分全部相等 那就是不合法的dict
        if(w1.length() > w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))){
            return "";
        }

        for(int k=0;k<minLen;k++){//然后通过对比共有的len的部分,找到第一个不相同的字符 然后构建关系
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
        for(char k : indegrees.keySet()){//然后从每个字符的被映射次数为0出发，表示这个字符是dict最小的，因为不被别的字符依赖
            if(indegrees.get(k)==0){
                q.offer(k);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            char curr = q.poll();
            sb.append(curr);
            //通过邻居映射关系，找到那些在去掉当前字符的映射次数，被映射字符如果自己被映射的次数也为0了，那么也可以加入判断
            for(char next : adjs.get(curr)){
                indegrees.put(next,indegrees.get(next)-1);
                if(indegrees.get(next)==0){
                    q.offer(next);
                }
            }
        }
        //最后构建的sb的长度如果等于了所有唯一字符的总数，表示没有环的依赖，就是合格的
        return sb.length()==indegrees.size()? sb.toString():"";
    }
}

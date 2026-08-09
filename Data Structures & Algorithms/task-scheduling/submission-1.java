class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] list = new int[26];
        for(int i=0;i<tasks.length;i++){
            list[tasks[i]-'A']++;
        }

        //不用管字母，上面将每个字母出现的次数都弄好了，pq用来把这些次数从大到小排，先处理出现次数多的
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int l : list){
            if(l>0){
                pq.offer(l);
            }
        }

        //这个queue用来储存[每个字母剩余次数，下一个冷却结束时间点]，从小到大排
        Queue<int[]> q = new LinkedList<>();
        int time = 0;//记录总次数
        while(!pq.isEmpty()||!q.isEmpty()){
            time++;

            //因为pq每次处理完都会弹出去，所以当pq为空的时候意味着当前没有可以处理的字母，time直接前进到queue里储存的最近的一个可处理字母的冷却时间点
            if(pq.isEmpty()){
                time=q.peek()[1];
            }else{
                //如果pq是有可处理字母的，那么就弹出来它的次数并且-1，如果还有剩，那就放进queue里，下个冷却点是 当前time+n
                int leftTime = pq.poll()-1;
                if(leftTime>0){
                    q.add(new int[]{leftTime,time+n});
                }
            }
            //每次都要检查一下 当queue不为空，当前time是否已经到达了某个字母的下个冷却点，如果是，那就把该字母的剩余处理次数重新放进pq里
            if(!q.isEmpty()&&q.peek()[1]==time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] list = new int[26];
        for(int i=0;i<tasks.length;i++){
            list[tasks[i]-'A']++;
        }


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int l : list){
            if(l>0){
                pq.offer(l);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty()||!q.isEmpty()){
            time++;

            if(pq.isEmpty()){
                time=q.peek()[1];
            }else{
                int leftTime = pq.poll()-1;
                if(leftTime>0){
                    q.add(new int[]{leftTime,time+n});
                }
            }

            if(!q.isEmpty()&&q.peek()[1]==time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}

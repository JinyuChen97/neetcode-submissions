class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int s:stones){
            pq.offer(s);
        }

        while(pq.size()>1){
            int one = pq.poll();
            int two = pq.poll();

            if(Math.abs(one-two)>0){
                pq.offer(Math.abs(one-two));
            }
        }

        return pq.isEmpty()?0:pq.peek();
    }
}

class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));

        for(int num : nums){
            this.pq.offer(num);
            if(pq.size()>k){
                this.pq.poll();
            }
        }
    }
    
    public int add(int val) {
        this.pq.offer(val);
        if(this.pq.size()>k){
            this.pq.poll();
        }
        return this.pq.peek();
    }
}

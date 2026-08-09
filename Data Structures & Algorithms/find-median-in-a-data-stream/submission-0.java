class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a,b));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
    boolean even=true;
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        even=!even;
    }
    
    public double findMedian() {
        return even? ((double)minHeap.peek()+(double)maxHeap.peek())/2 : (double)maxHeap.peek();
    }
}

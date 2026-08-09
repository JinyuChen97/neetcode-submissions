class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());

        queue.addAll(map.entrySet());

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            Map.Entry<Integer,Integer> ans = queue.poll();
            res[i] = ans.getKey();
        }
        return res;
    }
}

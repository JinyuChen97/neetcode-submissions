class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n]; //dist是记录n个地点经过k+1轮后的最优到达价格
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;//dist【src】始发点是0元，表示不需要钱就到

        for(int i=0;i<=k;i++){
            int[] temp = dist.clone();//k+1轮循环开始 temp记录本次飞行轮的各个最优解

            for(int[] flight : flights){
                int start = flight[0];
                int destination = flight[1];
                int price = flight[2];

                if(dist[start]==Integer.MAX_VALUE) continue;//如果dist【start】来自上一轮还是maxvalue表示不可达还，无法从这里开始，跳过

                if(dist[start]+price < temp[destination]){//看看这条新组合方案，上一轮也就是dist[start]+price 看看是否比目前已知到 destination 的价格更便宜
                    temp[destination]=dist[start]+price;
                }
            }
            dist = temp;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}

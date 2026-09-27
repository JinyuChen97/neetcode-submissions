class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        for(int i=0;i<=k;i++){
            int[] temp = dist.clone();
            for(int[] flight : flights){
                int start = flight[0];
                int end = flight[1];
                int price = flight[2];

                if(dist[start]==Integer.MAX_VALUE) continue;

                if(dist[start]+price < temp[end]){
                    temp[end]=dist[start]+price;
                }
            }
            dist = temp;
        }

        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}

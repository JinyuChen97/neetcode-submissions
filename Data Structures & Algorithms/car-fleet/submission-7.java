class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a,b)->Integer.compare(b[0],a[0]));

        int count = 1;
        double prevtime = (double)(target-pairs[0][0])/pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            double currtime = (double)(target-pairs[i][0])/pairs[i][1];
            if(currtime>prevtime){
                count++;
                prevtime = currtime;
            }
        }
        return count;
    }
}

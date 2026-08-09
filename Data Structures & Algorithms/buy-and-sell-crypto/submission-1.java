class Solution {
    public int maxProfit(int[] prices) {
        int hold=Integer.MIN_VALUE;
        int sold=0;
        for(int p : prices){
            hold = Math.max(hold,-p);
            sold = Math.max(sold,hold+p);
        }
        return sold;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        
        List<Integer> ans = new ArrayList<>();
        for(int l=0;l<=nums.length-k;l++){
            int r = l;
            int maxValue = Integer.MIN_VALUE;
            while(r-l+1<=k){
                maxValue = Math.max(maxValue,nums[r]);
                if(r-l+1==k){
                    ans.add(maxValue);
                }
                r++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

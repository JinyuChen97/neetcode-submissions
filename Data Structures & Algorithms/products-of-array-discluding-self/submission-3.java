class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);
        int prefix=1;

        for(int i=0;i<nums.length;i++){
            ans[i]=prefix*ans[i];
            prefix=prefix*nums[i];
        }

        int suffix=1;

        for(int i=nums.length-1;i>=0;i--){
            ans[i]=suffix*ans[i];
            suffix=suffix*nums[i];
        }
        return ans;
    }
}  

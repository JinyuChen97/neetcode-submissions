class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!ans.contains(nums[i])){
                ans.add(nums[i]);
            }else{
                return true;
            }
        }
        return false;
    }
}

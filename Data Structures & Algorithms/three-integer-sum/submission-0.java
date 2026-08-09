class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer,Integer> rec = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int num : nums){
            rec.put(num, rec.getOrDefault(num,0)+1);
        }

        for(int i=0;i<nums.length;i++){
            rec.put(nums[i],rec.get(nums[i])-1);
            if(i>0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1;j<nums.length;j++){
                rec.put(nums[j],rec.get(nums[j])-1);
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int target = -(nums[j]+nums[i]);
                if(rec.getOrDefault(target,0)>0){
                    ans.add(Arrays.asList(nums[i],nums[j],target));
                }
            }

            for(int j=i+1;j<nums.length;j++){
                rec.put(nums[j],rec.get(nums[j])+1);
            }
        }
        return ans;
    }
}

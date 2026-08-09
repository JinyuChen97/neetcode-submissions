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
            if(i>0 && nums[i] == nums[i-1]) continue;//第一个数之前所有可能性已经查过，再遇到直接跳过

            for(int j=i+1;j<nums.length;j++){
                rec.put(nums[j],rec.get(nums[j])-1);
                if(j>i+1 && nums[j] == nums[j-1]) continue;//第二个数之前所有可能性都查过，再遇到直接跳过

                int target = -(nums[j]+nums[i]);
                if(rec.getOrDefault(target,0)>0){
                    ans.add(Arrays.asList(nums[i],nums[j],target));
                }
            }

            for(int j=i+1;j<nums.length;j++){//每次完成第二个数轮询，都要恢复之前删掉的次数，类似重置
                rec.put(nums[j],rec.get(nums[j])+1);
            }
        }
        return ans;
    }
}

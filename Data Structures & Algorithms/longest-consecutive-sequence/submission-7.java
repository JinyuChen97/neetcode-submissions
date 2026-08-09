class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))continue;
            map.put(nums[i],1);

            int begin=nums[i];
            int end=nums[i];

            if(map.containsKey(nums[i]-1)){
                begin = nums[i]-map.get(nums[i]-1);
            }

            if(map.containsKey(nums[i]+1)){
                end = nums[i]+map.get(nums[i]+1);
            }

            max = Math.max(max,end-begin+1);

            map.put(begin,end-begin+1);
            map.put(end,end-begin+1);
        }
        return max;
    }
}

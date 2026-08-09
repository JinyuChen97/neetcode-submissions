class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int i:nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }

        List<Integer>[] freq = new List[nums.length+1];
        for(int i=0;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer,Integer> entry:count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];
        int index = 0;
        for(int i = freq.length-1;i>=0;i--){
            for(int f : freq[i]){
                if(index<k){
                    ans[index++] = f;
                }else{
                    return ans;
                }
            }
        }
        return ans;
    }
}

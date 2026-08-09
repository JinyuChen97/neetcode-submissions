class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> check = new HashMap<>();
        for(int i=1;i<=numbers.length;i++){
            int left = target-numbers[i-1];
            if(check.containsKey(left)){
                return new int[]{check.get(left),i};
            }
            check.put(numbers[i-1],i);
        }
        return new int[0];        
    }
}

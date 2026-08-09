// class Solution {
//     public int longestConsecutive(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         int res = 0;

//         for(int num : nums){
//             set.add(num);
//         }

//         for(int num : nums){
//             int tempMax = 0 ; int current = num;
//             while(set.contains(current)){
//                 tempMax++;
//                 current++;
//             }
//             res = Math.max(res,tempMax);
//         }
//         return res;
//     }
// }


class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);

        int res=0; int current= nums[0]; int tempMax=0; int i=0;

        while(i<nums.length){
            if(current != nums[i]){
                current = nums[i];
                tempMax = 0;
            }

            while(i<nums.length && current == nums[i]){
                i++;
            }

            tempMax++;
            current++;
            res = Math.max(res,tempMax);
        }
    return res;
    }
}
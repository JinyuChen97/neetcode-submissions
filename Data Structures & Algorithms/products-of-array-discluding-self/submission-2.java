// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int[] res = new int[n];
//         for(int i = 0 ;i < n;i++){
//             int ans = 1;
//             for(int j = 0;j<n;j++){
//                 if(i!=j){
//                     ans *= nums[j];
//                 }
//             }
//             res[i]=ans;
//         }
//         return res;
//     }
// }


// class Solution {
//     public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int prodSum = 1; int zeroCount = 0;
//         for(int i=0;i<n;i++){
//             if(nums[i]!=0){
//                 prodSum *= nums[i];
//             }else{
//                 zeroCount++;
//             }
//         }

//         if(zeroCount > 1){
//             return new int[n];
//         }

//         int[] res = new int[n];
//         for(int i=0;i<n;i++){
//             if(zeroCount>0){
//                 res[i] = nums[i] == 0 ? prodSum : 0;
//             }else{
//                 res[i] = prodSum/nums[i];
//             }    
//         }
//         return res;
//     }
// }  


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        for(int i=0;i<n;i++){
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}  

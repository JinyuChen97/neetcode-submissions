class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res= new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            int curr = temperatures[i];
            while(!stack.isEmpty() && curr > stack.peek()[0]){
                int[] pair = stack.pop();
                res[pair[1]] = i-pair[1];
            }
            stack.push(new int[]{curr,i});
        }
     return res;
    }
}

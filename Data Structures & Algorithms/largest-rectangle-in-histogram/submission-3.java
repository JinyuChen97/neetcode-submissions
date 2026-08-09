class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.isEmpty() && heights[i]<stack.peek()[0]){
                int[] top = stack.pop();
                int topHeight = top[0];
                int topStart = top[1];
                max=Math.max(max,topHeight * (i-topStart));
                start=topStart;
            }

            stack.push(new int[]{heights[i],start});
        }

        for(int[] pair : stack){
            int height = pair[0];
            int start = pair[1];
            max=Math.max(max,height * (heights.length-start));
        }
        return max;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0;i<=heights.length;i++){
            while(!stack.isEmpty() && (i==heights.length || heights[i] <= heights[stack.peek()])){
                int topindex = stack.pop();
                int topHeight = heights[topindex];
                int width = stack.isEmpty()?i:i-stack.peek()-1;
                max = Math.max(max, width*topHeight);
            }
            stack.push(i);
        }
        return max;
    }
}

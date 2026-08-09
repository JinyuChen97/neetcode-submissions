class Solution {
    public int largestRectangleArea1(int[] heights) {
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int minHeight = heights[i];
            for(int j=i;j<heights.length;j++){
                minHeight = Math.min(minHeight,heights[j]);
                maxArea = Math.max(maxArea, (j-i+1) * minHeight);
            }
        }
        return maxArea;
    }

        public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        int[] newHeights = new int[heights.length + 1];
        System.arraycopy(heights, 0, newHeights, 0, heights.length);
        newHeights[heights.length] = 0; // 哨兵元素，保证栈全部清空

        for(int i=0;i<newHeights.length;i++){
            //这里的解题思路就是每次如果找到更矮的height，就将这个更矮的height当作右边界，然后向左去计算所有可能的面积
            while(!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]){
                int height = newHeights[stack.pop()];//从这个目前最高的height开始向左一步一步计算面积
                int width = stack.isEmpty() ? i : i-stack.peek()-1;//i是当前index，stack.peek是最高height的前一个height的index，-1就是减掉i自己的宽度
                //每一次都从高到矮计算可能的面积，记录最大面积。最后一直到哨兵height-0，则会把stack里剩下的，都是矮的height拿出来，从高到矮全部计算面积
                //直到剩下的最后一个index，也就是heights里最矮的height，让它去乘于整个width的长度，就是哨兵0位于的heights.length。并计算比较最大面积。
                maxArea = Math.max(maxArea,height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

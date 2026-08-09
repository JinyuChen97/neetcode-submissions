class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        // 栈中保存 int[]，格式为：[起始索引 start, 高度 height]
        Stack<int[]> stack = new Stack<>(); 

        for (int i = 0; i < heights.length; i++) {
            int start = i; // 默认当前柱子的起始位置就是当前下标 i
            
            // 当栈不为空，且当前柱子高度比栈顶柱子矮时，说明栈顶柱子无法继续向右扩展
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                
                // 计算以 popped 柱子高度为基准的矩形面积：
                // 高度为 height，宽度为 (当前下标 i - 柱子能向左延伸到的起始索引 index)
                maxArea = Math.max(maxArea, height * (i - index));
                
                // 因为当前柱子比弹出的柱子矮，所以当前柱子向左最远可以延伸到被弹出柱子的起始位置
                start = index;
            }
            
            // 将当前柱子（带着更新后的 start 索引）压入栈中
            stack.push(new int[]{start, heights[i]});
        }

        // 遍历结束后，栈里剩余的柱子说明它们可以一路向右延伸到直方图的最右端 (heights.length)
        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        
        return maxArea;
    }
}

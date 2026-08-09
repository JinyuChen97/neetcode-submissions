public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>(); // 存柱子的下标索引
        // 注意这里的循环条件是 i <= n，i = n 充当了右侧高度为 0 的哨兵
        for (int i = 0; i <= n; i++) {    
            // 当 i == n 时强制触发（哨兵），或者当前柱子比栈顶柱子矮/相等时触发结算
            while (!stack.isEmpty() && 
                 (i == n || heights[stack.peek()] >= heights[i])) {         
                int height = heights[stack.pop()]; // 弹出栈顶高度            
                // 确定向左右扩展的最远宽度
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // 更新最大面积
                maxArea = Math.max(maxArea, height * width);
            }
            // 将当前索引入栈
            stack.push(i);
        }
        return maxArea;
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
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
}

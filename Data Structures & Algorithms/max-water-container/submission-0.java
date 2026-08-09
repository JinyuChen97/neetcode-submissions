class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i< n;i++){
            int leftBar = heights[i];
            for(int j =i+1;j<n;j++){
                int rightBar = heights[j];
                maxArea = Math.max(maxArea, Math.min(leftBar,rightBar)*(j-i));
            }
        }
        return maxArea;
    }
}
 
class Solution {
    public int maxArea(int[] heights) {
        int l=0;
        int r=heights.length-1;
        int max = 0;

        while(l<r){
            int cal = (r-l)*Math.min(heights[l],heights[r]);
            max=Math.max(cal,max);
            if(heights[l]<heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}

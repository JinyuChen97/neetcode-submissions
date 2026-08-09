class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }

        int l = 0;
        int r = height.length-1;
        int leftMax = height[l];
        int rightMax = height[r];
        int res = 0;
        //短板效应，找最短板才能算出能装多少水
        while(l<r){
            if(leftMax<rightMax){//左边的板比右边的板短，左边才能装水
                l++;
                leftMax = Math.max(leftMax,height[l]);//确定是当前l的位置板高 还是 之前记录的leftMax板高
                res += (leftMax-height[l]);//如果是之前leftMax大，那么自然就能装leftMax-当前位置高度的水， 反之，lefxMax会在上一行的逻辑中记录当前板的高度，自己减去自己，自然为0，不影响
            }else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += (rightMax-height[r]);
            }
        }
        return res;
    }
}

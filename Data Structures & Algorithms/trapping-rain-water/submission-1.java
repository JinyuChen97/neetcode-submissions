class Solution {
    public int trap(int[] height) {
        int l=0;
        int r=height.length-1;
        int lmax=height[l];
        int rmax=height[r];
        int count = 0;
        while(l<=r){
            if(lmax<rmax){
                lmax = Math.max(lmax,height[l]);
                count +=(lmax-height[l]);
                l++;
            }else{
                rmax = Math.max(rmax,height[r]);
                count +=(rmax-height[r]);
                r--;
            }
        }
        return count;
    }
}

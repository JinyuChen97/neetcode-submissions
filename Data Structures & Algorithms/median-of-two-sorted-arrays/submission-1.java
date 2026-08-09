class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = 0;
        int l2 = 0;
        int m1 = 0;
        int m2 = 0;

        int count = (nums1.length+nums2.length)/2;
        for(int i=0;i<=count;i++){
            m2=m1;
            if(l1<nums1.length && l2<nums2.length){
                if(nums1[l1]<nums2[l2]){
                    m1=nums1[l1++];
                }else{
                    m1=nums2[l2++];
                }
            }else{
                if(l1<nums1.length){
                    m1=nums1[l1++];
                }

                if(l2<nums2.length){
                    m1=nums2[l2++];
                }
            }
        }

        return (nums1.length+nums2.length)%2==1 ? (double)m1 : (double)(m1+m2)/2;
    }
}

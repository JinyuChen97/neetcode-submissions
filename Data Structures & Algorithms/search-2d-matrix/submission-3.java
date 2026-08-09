class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int r=matrix.length*matrix[0].length-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(matrix[mid/matrix[0].length][mid%matrix[0].length]==target){
                return true;
            }else if(matrix[mid/matrix[0].length][mid%matrix[0].length] < target){
                l++;
            }else{
                r--;
            }
        }
        return false;
    }
}

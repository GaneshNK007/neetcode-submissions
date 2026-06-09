class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;

        int l=0;
        int r=row*col-1;

        while(l<=r){
            int mid=l+(r-l)/2;
            int ro=mid/col;
            int co=mid%col;

            if(target==matrix[ro][co]) return true;
            else if(target < matrix[ro][co]) r=mid-1;
            else l=mid+1; 
        }

        return false;
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int k = n+m;

        int[] ans = new int[k];

        int l1 = 0;
        int l2 = 0;
        int i = 0;

        while(l1 < n && l2 < m){
            if(nums1[l1] <= nums2[l2]){
                ans[i++] = nums1[l1++];
            }
            else{
                ans[i++] = nums2[l2++];
            }
        }

        while(l1 < n){
            ans[i++] = nums1[l1++];
        }

        while(l2 < m){
            ans[i++] = nums2[l2++];
        }


        if(k % 2 ==0){
            float a = ans[k/2];
            float b = ans[(k/2)-1];

            return (float)(a+b)/2;
        }

        else{
            return ans[k/2];
        }
    }
}

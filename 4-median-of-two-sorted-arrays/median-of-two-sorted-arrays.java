class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) findMedianSortedArrays(nums2, nums1);

        int[] sortedArr = new int[n1+n2];
        int pos1 = 0, pos2 = 0, pos = 0;
        while(pos1 < n1 && pos2 < n2) {
            if(nums1[pos1] <= nums2[pos2]) {
                sortedArr[pos++] = nums1[pos1++];
            }
            else sortedArr[pos++] = nums2[pos2++];
        }

        while(pos1 < n1) {
            sortedArr[pos++] = nums1[pos1++];
        }

        while(pos2 < n2){
            sortedArr[pos++] = nums2[pos2++];
        }

        /*for(int i=0;i<n1+n2;i++){
            System.out.print(sortedArr[i] + " --- ");
        }
        System.out.println();

        System.out.println(sortedArr[((n1+n2)/2)-1]);
        System.out.println(sortedArr[((n1+n2)/2)]);
        */

        return (n1+n2)%2 == 1 ? 1d*sortedArr[(n1+n2)/2] 
                                : 1d*(sortedArr[((n1+n2)/2)-1] 
                                    + sortedArr[(n1+n2)/2])/(1d*2);
    }
}
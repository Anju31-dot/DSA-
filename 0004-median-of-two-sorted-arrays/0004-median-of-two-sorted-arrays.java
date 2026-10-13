class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int [] merged = new int[n1 + n2];
        int i =0;
        int j =0;
        int k =0;
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                merged[k]=nums1[i];
                i++;
            }
            else{
                merged[k]=nums2[j];
                j++;
            }
            k++;

        }
        while(i<n1){
            merged[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n2){
            merged[k]=nums2[j];
            j++;
            k++;
        }
        int n = merged.length;
        if(n%2==1){
            return merged[n/2];
        }
        else{
            int x = merged[n/2];
            int y = merged[(n/2)-1];
            return (x+y)/2.0;
        }
    }
}
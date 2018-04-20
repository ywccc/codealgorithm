class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int k = (len1 + len2 + 1)/2;
        
        double res1 = search(nums1,0,len1-1,nums2,0,len2-1,k);
        if((len1+len2)%2 == 0)
        {
            double res2 = search(nums1,0,len1-1,nums2,0,len2-1,k+1);
            return (res1 + res2)/2.0;
        }
        else return res1;
    }
    
    public double search(int[] nums1, int i1, int j1, int[] nums2, int i2,int j2,int k)
    {
        if(i1>j1) return (double)nums2[i2+k-1];
        if(i2>j2) return (double)nums1[i1+k-1];
        
        int mid1 = (i1+j1)/2;
        int mid2 = (i2+j2)/2;
        if(nums1[mid1] < nums2[mid2])
        {
            if(k > mid1-i1+1+mid2-i2)
            {
                return search(nums1,mid1+1,j1,nums2,i2,j2,k-mid1+i1-1);
            }
            else
            {
                return search(nums1,i1,j1,nums2,i2,mid2-1,k);
            }
        }
        else
        {
            if(k > mid2-i2+1+mid1-i1)
            {
                return search(nums1,i1,j1,nums2,mid2+1,j2,k-mid2+i2-1);
            }
            else
            {
                return search(nums1,i1,mid1-1,nums2,i2,j2,k);
            }
        }
    }
}
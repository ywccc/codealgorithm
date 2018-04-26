class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if(nums1 == null || nums2 == null || nums1.length + nums2.length < k) return new int[k];
        
        int[] res = new int[k];
        int m = nums1.length;
        int n = nums2.length;
        if(m + n == k) return merge(nums1,nums2);
        for(int i = Math.max(0,k-n); i <= Math.min(k,m); ++i)
        {
            int[] arr1 = findmax(nums1,i);
            int[] arr2 = findmax(nums2,k-i);
            
            int[] tmp = merge(arr1,arr2);
            if(compare(tmp,0,res,0)) res = tmp;
        }
        return res;
    }
    
    
    public int[] findmax(int[] nums, int k)
    {
        int[] res = new int[k];
        if(k == 0) return res;
        int j = 0;
        
        for(int i = 0; i < nums.length; ++i)
        {
            while(j + nums.length - i > k && j > 0 && res[j-1] < nums[i]) --j;
            if(j < k) res[j++] = nums[i];
        }
        return res;
    }
    
    public boolean compare(int[] nums1 , int ii, int[] nums2, int jj)
    {
        int i , j;
        for(i = ii, j = jj; i < nums1.length && j < nums2.length; ++i, ++j)
        {
            if(nums1[i] > nums2[j]) return true;
            if(nums1[i] < nums2[j]) return false;
        }
        return i != nums1.length;
    }
    
    public int[] merge(int[] nums1, int[] nums2)
    {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0,j = 0, pos = 0;
        while(pos < res.length)
        {
            if(compare(nums1,i,nums2,j)) res[pos++] = nums1[i++];
            else res[pos++] = nums2[j++];
        }
        return res;
    }
}
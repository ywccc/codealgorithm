class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = nums.length-1;
        
        while(i < j)
        {
            int mid = i + (j-i)/2;
            if(nums[mid] > nums[j])
            {
                i = mid+1;
            }
            else
            {
                j = mid;
            }
        }
        
        return nums[i];
        
    }
}
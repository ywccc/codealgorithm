class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0; 
        int j = nums.length-1;
        int res = Math.min(nums[0],nums[nums.length-1]);
        while(i < j)
        {
            int mid = (j-i)/2+i;
            res = Math.min(nums[mid],res);
            if(nums[i] == nums[mid])
            {
                ++i;
            }
            else if(nums[j] == nums[mid])
            {
                --j;
            }
            else if(nums[i] < nums[mid])
            {
                if(nums[j] < nums[mid])
                {
                    i = mid;
                }
                else
                {
                    return Math.min(res,nums[i]);
                }
            }
            else if(nums[i] > nums[mid])
            {
                j = mid;
            }
            
        }
        
        return Math.min(res,nums[i]);
    }
}

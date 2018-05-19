class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        int sum = 1;
        int i = 0;
        int j = 0;
        while(j < nums.length)
        {
            if(nums[j] >= k)
            {
                sum = 1;
                ++j;
                i = j;
            }
            else
            {
                sum *= nums[j];
                if(sum < k)
                {
                    res += j-i+1;
                    ++j;
                }
                else
                {
                    while(sum >= k)
                    {
                        sum /= nums[i];
                        ++i;
                    }
                    res += j-i+1;
                    ++j;
                }
            }
            
        }
        return res;
        
    }
}

class Solution {
    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int i = nums.length-1; i >= 2; --i)
        {
            int j = 0;
            int k = i-1;
            while(j < k)
            {
                if(nums[j] + nums[k] > nums[i])
                {
                    res += k-j;
                    --k;
                }
                else
                {
                    ++j;
                }
            }
        }
        return res;
    }
}

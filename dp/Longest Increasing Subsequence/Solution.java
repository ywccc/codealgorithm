class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int[] help = new int[nums.length];
        int size = 0;
        for(int i = 0; i < nums.length; ++i)
        {
            int k = 0;
            int j = size;
            while(k != j)
            {
                int m = (k + j)/2;
                if(help[m] < nums[i])
                {
                    k = m+1;
                }
                else
                {
                    j = m;
                }
            }
            help[k] = nums[i];
            if(k == size) ++size;
        }
        return size;
        
    }
}
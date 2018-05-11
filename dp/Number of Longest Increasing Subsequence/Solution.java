class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] res = new int[nums.length];
        int[] help = new int[nums.length];
        
        res[0] = 1;
        help[0] = nums[0];
        int l = 0;
        int r = 0;
        for(int i = 1; i < nums.length; ++i)
        {
            if(nums[i] > help[r])
            {
                ++r;
                help[r] = nums[i];
                res[i] = r+1;
            }
            else
            {
                int m = 0;
                int n = r;
                while(m < n)
                {
                    int mid = (m + n)/2;
                    if(help[mid] == nums[i])
                    {
                        res[i] = mid+1;
                        break;
                    }
                    else if(help[mid] < nums[i])
                    {
                        m = mid+1;
                    }
                    else
                    {
                        n = mid;
                    }
                }
                if(res[i] == 0)
                {
                    res[i] = m+1;
                    help[m] = nums[i];
                }
            }
            //System.out.println(res[i]);
        }
        //System.out.println(r);
        int[] count = new int[nums.length];
        count[0] = 1;
        for(int i = 1; i < nums.length; ++i)
        {
            for(int j = 0; j < i; ++j)
            {
                if(nums[j] < nums[i] && res[j] == res[i]-1)
                {
                    count[i] += count[j];
                }
            }
            if(count[i] == 0) count[i] = 1;
        }
        int ans = 0;
        for(int i = 0; i < nums.length; ++i)
        {
            if(res[i] == r+1)
            {
                ans += count[i];
            }
        }
        return ans;
    }
}

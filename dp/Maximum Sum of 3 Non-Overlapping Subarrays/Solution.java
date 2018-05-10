class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];
        if(nums == null || nums.length == 0) return res;
        int len = nums.length;
        if(3*k > len) return res;
        
        int[] left = new int[len];
        int[] right = new int[len];
        int[] sum = new int[len];
        for(int i = 0; i < len; ++i) sum[i] = ((i==0)?0:sum[i-1]) + nums[i];
        int max = 0;
        for(int i = 0; i <= len-3*k; ++i)
        {
            int tmp = sum[i+k-1]- ((i == 0)?0:sum[i-1]); // i ... i+k-1
            //System.out.println(tmp);
            if(tmp > max)
            {
                max = tmp;
                left[i] = i;
            }
            else
            {
                left[i] = left[i-1];
            }
        }
        //System.out.println(left[1]);
        max = 0;
        for(int i = len-k; i >= 2*k; --i)
        {
            int tmp = sum[i+k-1] - sum[i-1];
            if(tmp > max)
            {
                max = tmp;
                right[i] = i;
            }
            else
            {
                right[i] = right[i+1];
            }
        }
        
        max = sum[3*k-1];
        
        res[0] = 0;
        res[1] = k;
        res[2] = 2*k;
        for(int i = k; i <= len-2*k; ++i)
        {
            int l = left[i-k];
            int r = right[i+k];
            int tmp = sum[l+k-1] - ((l == 0)?0:sum[l-1]) + sum[i+k-1] - sum[i-1] + sum[r+k-1] - sum[r-1];
            if(tmp > max)
            {
                max = tmp;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
        
    }
}

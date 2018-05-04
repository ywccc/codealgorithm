class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len  = nums.length;
        int[] num = new int[len+2];
        for(int i = 1; i < len+1; ++i)
        {
            num[i] = nums[i-1];
        }
        num[0] = 1;
        num[len+1] = 1;
        int[][] help = new int[len+2][len+2];
        for(int i = 1; i <= len; ++i) //number in between
        {
            for(int j = 0; j <= len-i; ++j) // j = left, right = j+i+1
            {
                for(int k = j+1; k <= j+i; ++k)
                {
                    help[j][j+i+1] = Math.max(help[j][j+i+1],help[j][k] + help[k][j+i+1] + num[j]*num[k]*num[j+i+1]);
                }
            }
        }
        return help[0][len+1];
        
    }
}

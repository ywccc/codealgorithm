class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        HashSet<Integer> help = new HashSet<Integer>();
        for(int i = 0; i < nums.length; ++i) help.add(nums[i]);
        
        int res = 0;
        for(int i = 0; i < nums.length; ++i)
        {
            if(!help.contains(nums[i])) continue;
            int sum = 0;
            int tmp = nums[i];
            while(help.contains(tmp))
            {
                ++sum;
                help.remove(tmp);
                --tmp;
            }
            tmp = nums[i]+1;
            while(help.contains(tmp))
            {
                ++sum;
                help.remove(tmp);
                ++tmp;
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
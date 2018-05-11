class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int i = 0; i < nums.length; ++i) sum += nums[i];
        if(sum % k != 0) return false;
        boolean[] visit = new boolean[nums.length];
        return dfs(nums,visit,k,sum/k,0,0);
    }
    
    public boolean dfs(int[] nums, boolean[] visit, int k, int target, int start, int sum)
    {
        if(k == 0) return true;
        if(sum == target && target > 0) return dfs(nums, visit,k-1,target,0,0);
        for(int i = start; i < nums.length; ++i)
        {
            if(!visit[i])
            {
                visit[i] = true;
                if(dfs(nums, visit,k,target,i+1,sum+nums[i])) return true;
                visit[i] = false;
            }
        }
        return false;
    }
}

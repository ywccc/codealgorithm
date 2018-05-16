class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> help = new HashMap<Integer,Integer>();
        help.put(0,1);
        if(nums[0] == 0) help.put(0,2);
        else help.put(nums[0],1);
        int pre = nums[0];
        
        int res = (nums[0] == k)?1:0;
        for(int i = 1; i < nums.length; ++i)
        {
            pre += nums[i];
            res += help.getOrDefault(pre-k,0);
            if(!help.containsKey(pre))
            {
                help.put(pre,1);
            }
            else
            {
                help.put(pre,help.get(pre)+1);
            }
        }
        return res;
    }
}

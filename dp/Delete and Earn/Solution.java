class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> help = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; ++i)
        {
            if(!help.containsKey(nums[i]))
            {
                help.put(nums[i],1);
            }
            else
            {
                help.put(nums[i],help.get(nums[i])+1);
            }
        }
        
        int[] res = new int[10001];
        res[1] = (help.containsKey(1))?help.get(1):0;
        for(int i = 2; i < res.length; ++i)
        {
            if(!help.containsKey(i)) res[i] = res[i-1];
            else
            {
                System.out.println(help.get(i));
                res[i] = Math.max(res[i-1],res[i-2] + i*help.get(i));
            }
        }
        return res[10000];
    }
}

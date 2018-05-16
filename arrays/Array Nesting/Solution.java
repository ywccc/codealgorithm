class Solution {
    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> help = new HashMap<Integer,Integer>();
        int res = 0;
        for(int i = 0; i < nums.length; ++i)
        {
            if(help.containsKey(i)) continue;
            HashSet<Integer> tmp = new HashSet<Integer>();
            int t = i;
            int count = 0;
            while(!tmp.contains(t))
            {
               tmp.add(t);
                t = nums[t];
                ++count;
            }
            for(Integer s : tmp)
            {
                help.put(s,count);
            }
            res = Math.max(res,count);
        }
        return res;
    }
}

class Solution {
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length == 0) return false;
        
        HashMap<Integer,HashSet<Integer>> help = new HashMap<Integer,HashSet<Integer>>();
        help.put(0,new HashSet<Integer>());
        help.get(0).add(1);
        
        for(int i = 1; i < stones.length-1; ++i)
        {
            help.put(stones[i],new HashSet<Integer>());
        }
        
        int target = stones[stones.length-1];
        
        for(int i = 0; i < stones.length-1; ++i)
        {
            for(Integer step: help.get(stones[i]))
            {
                int reach = step + stones[i];
                if(reach == target) return true;
                HashSet<Integer> set = help.get(reach);
                if(set != null)
                {
                   if(step > 1 && reach + step - 1 <= target) help.get(reach).add(step-1);
                    if(reach + step <= target) help.get(reach).add(step);
                    if(reach + step +1 <= target) help.get(reach).add(step+1);
                }
            }
        }
        
        return false;
    }
}
class Solution {
    class TrieNode
    {
        TrieNode[] child;
        
        TrieNode()
        {
            child = new TrieNode[2];
        }
    };
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        TrieNode root = new TrieNode();
        for(int i = 0; i < nums.length; ++i)
        {
            int num = nums[i];
            TrieNode tmp = root;
            for(int j = 31; j >= 0; --j)
            {
                int t = (num >>> j) & 1;
                if(tmp.child[t] == null)
                {
                    tmp.child[t] = new TrieNode();
                }
                tmp = tmp.child[t];
            }
        }
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i)
        {
            int num = nums[i];
            int sum = 0;
            TrieNode tmp = root;
            for(int j = 31; j >= 0; --j)
            {
                int bit = (num >>> j) & 1;
                if(tmp.child[1-bit] != null)
                {
                    sum += (1 << j);
                    tmp = tmp.child[1-bit];
                }
                else
                {
                    tmp = tmp.child[bit];
                }
            }
            
            res = Math.max(sum,res);
        }
        
        return res;
        
        
    }
}
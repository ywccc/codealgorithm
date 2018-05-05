class Solution {
    class envelope{
        int w;
        int h;
        
        envelope(int width, int height)
        {
            w = width;
            h = height;
        }
        
    };
    
    public int maxEnvelopes(int[][] nums) {
        if(nums == null || nums.length == 0 || nums[0] == null || nums[0].length == 0) return 0;
        
        
        envelope[] help = new envelope[nums.length];
        for(int i = 0; i < nums.length; ++i)
        {
            help[i] = new envelope(nums[i][0],nums[i][1]);
        }
        
        Arrays.sort(help,new Comparator<envelope>(){
            
            public int compare(envelope a, envelope b)
            {
                if(a.w == b.w)
                {
                    return a.h - b.h;
                }
                else
                {
                    return a.w - b.w;
                }
            }
        });
        
        int[] res = new int[nums.length];
        int max = 1;
        res[0] = 1;
        for(int i = 1; i < nums.length; ++i)
        {
            res[i] = 1;
            for(int j = 0; j < i; ++j)
            {
                if(help[j].w < help[i].w && help[j].h < help[i].h)
                {
                    res[i] = Math.max(res[i],res[j] + 1);
                    max = Math.max(res[i],max);
                }
            }
        }
        return max;
    }
}

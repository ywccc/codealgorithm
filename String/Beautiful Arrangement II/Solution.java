class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        if(k > n-1) return res;
        
        int i = 2;
        int j = n;
        res[0] = 1;
        boolean flag = false;
        if(k%2 == 0) flag = true;
        for(int r = 1; r < n; ++r)
        {
            if(k == 1 )
            {
                if(!flag)
                {
                    res[r] = i;
                    ++i;
                }
                else
                {
                    res[r] = j;
                    --j;
                }
                
            }
            else
            {
                if(r%2 == 0) 
                {
                    res[r] = i;
                    ++i;
                }
                else
                {
                    res[r] = j;
                    --j;
                }
                --k;
            }
        }
        return res;
    }
}

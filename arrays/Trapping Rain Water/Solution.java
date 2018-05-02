class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int l = 0;
        int r = height.length-1;
        int lmost = height[l];
        int rmost = height[r];
        int res = 0;
        while(l <= r)
        {
            lmost = Math.max(lmost,height[l]);
            rmost = Math.max(rmost,height[r]);
            if(lmost < rmost)
            {
                res += lmost - height[l];
                ++l;
            }
            else
            {
                res += rmost - height[r];
                --r;
            }
        }
        return res;
        
    }
}
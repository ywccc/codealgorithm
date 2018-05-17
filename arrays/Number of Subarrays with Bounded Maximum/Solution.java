class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        if(A.length == 0) return 0;
        int res = 0;
        int len = 0;
        int pre = 0;
        for(int i = 0; i < A.length; ++i)
        {
            if(A[i] > R)
            {
                len = 0;
                pre = 0;
            }
            else if(A[i] <= R && A[i] >= L)
            {
                ++len;
                res += len;
                pre = len;
            }
            else
            {
                res += pre;
                ++len;
            }
        }
        return res;
        
    }
}

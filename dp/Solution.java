class Solution {
    public int maxA(int N) {
        int[] help = new int[N+1];
        
        for(int i = 0; i <= N; ++i)
        {
            help[i] = i;
            for(int j = 1; j <= i-3; ++j)
            {
                help[i] = Math.max(help[i],help[j]*(i-j-1));
            }
        }
        return help[N];
    }
}

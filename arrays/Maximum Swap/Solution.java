class Solution {
    public int maximumSwap(int num) {
        if(num == 0) return 0;
        int[] help = new int[8];
        int[] digit = new int[10];
        Arrays.fill(digit,-1);
        int n = num;
        int i = 0;
        int len = 0;
        while(n != 0)
        {
            help[i] = n % 10;
            if(digit[help[i]] == -1) digit[help[i]] = i;
            ++len;
            ++i;
            n /= 10;
        }
        
        for(int j = len-1; j >= 0; --j)
        {
            for(int k = 9; k > help[j]; --k)
            {
                if(digit[k] == -1 || digit[k] > j) continue;
                else
                {
                    int pos = digit[k];
                    help[pos] = help[j];
                    help[j] = k;
                    int res = 0;
                    for(int m = len-1; m>=0; --m)
                    {
                        res = res*10+help[m];
                    }
                    return res;
                }
            }
        }
        return num;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        int[] help = new int[26];
        int max = 0;
        int count = 0;
        for(int i = 0; i < tasks.length; ++i)
        {
            ++help[tasks[i]-'A'];
            if(help[tasks[i]-'A'] > max)
            {
                max = help[tasks[i]-'A'];
                count = 1;
            }
            else if(help[tasks[i]-'A'] == max)
            {
                ++count;
            }
        }
        return Math.max(tasks.length,((max-1)*(n+1) + count));
        
    }
}

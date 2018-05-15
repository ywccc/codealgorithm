class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int i = 0 ; i < updates.length; ++i)
        {
            res[updates[i][0]] += updates[i][2];
            if(updates[i][1] < length-1)
            {
                res[updates[i][1]+1] -= updates[i][2];
            }
        }
        
        for(int i = 1; i < length; ++i)
        {
            res[i] += res[i-1];
        }
        return res;
    }
}

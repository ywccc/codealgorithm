class Solution {
    HashMap<Integer,Boolean> help;
    boolean[] used;
    public boolean canIWin(int max, int total) {
        if(max >= total) return true;
        if((max+1)*max/2 < total) return false;
        if(total <= 0) return true;
        
        help = new HashMap<Integer,Boolean>();
        used = new boolean[max+1];
        
        return check(total);
    }
    
    public boolean check(int total)
    {
        if(total <= 0) return false;
        int key = getkey(used);
        if(!help.containsKey(key))
        {
            for(int i = 1; i < used.length; ++i)
            {
                if(used[i]) continue;
                used[i] = true;
                if(!check(total - i))
                {
                    used[i] = false;
                    help.put(key,true);
                    return true;
                }
                used[i] = false;
            }
            help.put(key,false);
        }
        return help.get(key);
    }
    
    public int getkey(boolean[] used)
    {
        int num = 0;
        for(int i = 0; i < used.length; ++i)
        {
            num <<= 1;
            if(used[i]) ++num;
        }
        return num;
    }
}

class Solution {
    
    
    //bfs同时构造关系，因为是最短距离，所以不需要考察每一对之间是否相连
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<String>(wordList);
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        if(!set.contains(endWord)) return new ArrayList<List<String>>();
        if(set.contains(beginWord)) set.remove(beginWord);
        
        
        List<List<String>> res = new ArrayList<List<String>>();
        int distance = bfs(beginWord,endWord,set,map);
        if(distance == 0) return res;
    
        List<String> item = new ArrayList<String>();
        item.add(beginWord);
        dfs(res,item,beginWord,endWord,map,set,distance,1);
        return res;
        
        
    }
    
    public int bfs(String begin,String end, HashSet<String> set, HashMap<String,ArrayList<String>> map)
    {
        HashSet<String> help = new HashSet<String>(set);
        Queue<String> queue = new LinkedList<String>();
        int distance = 1;
        queue.offer(begin);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            HashSet<String> help2 = new HashSet<String>(help);
            for(int i = 0; i < size; ++i)
            {
                String tmp = queue.poll();
                if(tmp.equals(end))
                {
                    return distance;
                }
                if(!map.containsKey(tmp))
                {
                    map.put(tmp,new ArrayList<String>());
                }
                for(int j = 0; j < tmp.length(); ++j)
                {
                    char[] s = tmp.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ++ch)
                    {
                        s[j] = ch;
                        String ss = String.valueOf(s);
                        if(!ss.equals(tmp) && help2.contains(ss))
                        {
                            map.get(tmp).add(ss);
                        }
                        if(!ss.equals(tmp) && help.contains(ss))
                        {
                            queue.offer(ss);
                            help.remove(ss);
                        }
                        
                    }
                }
            }
            ++distance;
        }
        return 0;
    }
    
    public void dfs(List<List<String>> res, List<String> item, String begin, String end,HashMap<String,ArrayList<String>> map,HashSet<String> set, int distance,int cur)
    {
        if(begin.equals(end) && cur == distance)
        {
            res.add(new ArrayList<String>(item));
            return;
        }
        if(cur >= distance) return;
        
        for(String each : map.get(begin))
        {
            if(set.contains(each))
            {
                item.add(each);
                ++cur;
                set.remove(each);
                dfs(res,item,each,end,map,set,distance,cur);
                item.remove(item.size()-1);
                --cur;
                set.add(each);
            }
            
        }
    }
}

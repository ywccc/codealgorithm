class Solution {
    
    class TrieNode{
        int index;
        HashMap<Character,TrieNode> next;
        List<Integer> record;
        TrieNode()
        {
            index = -1;
            next = new HashMap<Character,TrieNode>();
            record = new ArrayList<Integer>();
        }
    };
    
    class TrieTree{
        TrieNode root;
        
        TrieTree()
        {
            root = new TrieNode();
        }
        
        public void insert(String tmp,int id)
        {
            if(tmp == null || tmp.length() == 0)
            {
                //root.index = id;
                return;
            }
            TrieNode now = root;
            for(int i = tmp.length()-1; i >= 0; --i)
            {
                char ch = tmp.charAt(i);
                if(!now.next.containsKey(ch))
                {
                    now.next.put(ch,new TrieNode());
                }
                now = now.next.get(ch);
                now.record.add(id);
                if(i == 0) {
                    now.index = id;
                }
            }
        }
    }
    
    
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0) return res;
        
        TrieTree help = new TrieTree();
        for(int i = 0; i < words.length; ++i) help.insert(words[i],i);
        for(int i = 0; i < words.length; ++i) 
        {
            if(words[i].equals(""))
            {
                for(int j = 0; j < words.length; ++j)
                {
                    if(i != j && check(words[j],0,words[j].length()-1))
                    {
                        List<Integer> tmp1 = new ArrayList<Integer>();
                        List<Integer> tmp2 = new ArrayList<Integer>();
                        tmp1.add(i);
                        tmp1.add(j);
                        tmp2.add(j);
                        tmp2.add(i);
                        res.add(tmp1);
                        res.add(tmp2);
                    }
                }
            }
            else search(words,words[i],i,help.root,res);
        }
        
        return res;
    }
    
    public void search(String[] words,String word,int i, TrieNode root,List<List<Integer>> res)
    {
        if(word.length() == 0)
        {
            if(root.index != -1 && i != root.index)
            {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                tmp.add(root.index);
                res.add(tmp);
            }
            for(Integer id : root.record)
            {
                if(id != root.index && i != id)
                {
                    if(check(words[id],0,words[id].length()-words[i].length()-1))
                    {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(i);
                        tmp.add(id);
                        res.add(tmp);
                    }
                }
            }
            return;
        }
        if(root.index != -1 && i != root.index)
        {
            if(check(words[i],words[root.index].length(),words[i].length()-1))
            {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                tmp.add(root.index);
                res.add(tmp);
            }
        }
        
        if(root.next.containsKey(word.charAt(0)))
        {
            search(words,word.substring(1),i,root.next.get(word.charAt(0)),res);
        }
        
    }
    
    public boolean check(String word,int i, int j)
    {
        while(i < j)
        {
            if(word.charAt(i) != word.charAt(j))
            {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
}
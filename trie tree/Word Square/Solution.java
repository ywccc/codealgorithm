class Solution {
    class TrieNode{
        boolean isEnd;
        HashMap<Character,TrieNode> next;
        List<String> prefix;
        
        TrieNode()
        {
            isEnd = false;
            next = new HashMap<Character,TrieNode>();
            prefix = new ArrayList<String>();
        }
    };
    
    class TrieTree{
        TrieNode root;
        
        TrieTree()
        {
            root = new TrieNode();
        }
        
        public void insert(String tmp)
        {
            if(tmp == null || tmp.length() == 0) return;
            TrieNode now = root;
            for(int i = 0; i < tmp.length(); ++i)
            {
                char ch = tmp.charAt(i);
                if(!now.next.containsKey(ch))
                {
                    now.next.put(ch,new TrieNode());
                }
                now = now.next.get(ch);
                now.prefix.add(tmp);
                if(i == tmp.length()-1) now.isEnd = true;
            }
        }
    };
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(words == null || words.length == 0) return res;
        
        TrieTree help = new TrieTree();
        for(int i = 0; i < words.length; ++i)
        {
            help.insert(words[i]);
        }
        
        List<String> tmp = new ArrayList<String>();
        int len = words[0].length();
        for(int i = 0; i < words.length; ++i)
        {
            tmp.add(words[i]);
            search(res,tmp,len,words[i],help.root);
            tmp.remove(tmp.size()-1);
        }
        return res;
    }
    
    public void search(List<List<String>> res, List<String> tmp, int len, String word,TrieNode root)
    {
        if(tmp.size() == len)
        {
            res.add(new ArrayList<String>(tmp));
            return;
        }
        
        int size = tmp.size();
        TrieNode now = root;
        for(int i = 0; i < size; ++i)
        {
            char ch = tmp.get(i).charAt(size);
            if(!now.next.containsKey(ch))
            {
                return;
            }
            now = now.next.get(ch);
        }
        for(String w : now.prefix)
        {
            tmp.add(w);
            search(res,tmp,len,w,root);
            tmp.remove(tmp.size()-1);
        }
        
        
    }
}
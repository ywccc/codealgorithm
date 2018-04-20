class Solution {
    
    class TrieNode{
        String s;
        boolean isEnd;
        HashMap<Character,TrieNode> next;
        
        TrieNode()
        {
            s = "";
            isEnd = false;
            next = new HashMap<Character,TrieNode>();
        }
    };
    
    
    class TrieTree{
        TrieNode root;
        
        TrieTree(){
            root = new TrieNode();
        }
        
        public void insert(String tmp)
        {
            if(tmp == null || tmp.length() == 0) return;
            
            char[] help = tmp.toCharArray();
            TrieNode now = root;
            for(int i = 0; i < help.length; ++i)
            {
                char ch = help[i];
                if(!now.next.containsKey(ch))
                {
                    now.next.put(ch,new TrieNode());
                }
                now = now.next.get(ch);
                if(i == help.length-1)
                {
                    now.isEnd = true;
                    now.s = tmp;
                }
            }
        }
    };
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return res;
        if(words == null || words.length == 0) return res;
        
        TrieTree help = new TrieTree();
        for(int i = 0; i < words.length; ++i)
        {
            help.insert(words[i]);
        }
        
        for(int i = 0; i < board.length; ++i)
        {
            for(int j = 0; j < board[0].length; ++j)
            {
                dfs(board,i,j,help.root,res);
            }
        }
        return res;
    }
    
    public void dfs(char[][] board,int i,int j, TrieNode root, List<String> res)
    {
        if(root.isEnd == true)
        {
            if(!res.contains(root.s))
            {
                res.add(root.s);
                return;
            }
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 0 || root == null)
        {
            return;
        }
        if(root.next.containsKey(board[i][j]))
        {
            for(int m = 0; m < 4; ++m)
            {
                char now = board[i][j];
                board[i][j] = 0;
                dfs(board,i+dx[m],j+dy[m],root.next.get(now),res);
                board[i][j] = now;
            }
        }
    }
}
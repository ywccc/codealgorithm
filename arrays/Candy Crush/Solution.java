class Solution {
    public int[][] candyCrush(int[][] board) {
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0) return board;
        
        HashSet<Integer> help = new HashSet<Integer>();
        boolean flag = true;
        
        while(flag)
        {
            help = new HashSet<Integer>();
            for(int i = 0; i < board.length; ++i)
            {
                for(int j = 0; j < board[0].length; ++j)
                {
                    int tmp = board[i][j];
                    if(tmp == 0) continue;
                    if(i >= 2 && board[i-2][j] == tmp && board[i-1][j] == tmp)
                    {
                        help.add(100*(i-2)+j);
                        help.add(100*(i-1)+j);
                        help.add(100*i+j);
                    }
                    if(j >= 2 && board[i][j-2] == tmp && board[i][j-1] == tmp)
                    {
                        help.add(100*i+j-2);
                        help.add(100*i+j-1);
                        help.add(100*i+j);
                    }
                }
            }
            if(help.size() == 0) return board;
            for(Integer tmp : help)
            {
                int x = tmp/100;
                int y = tmp%100;
                board[x][y] = 0;
            }
            drop(board);
        }
        return board;
    }
    public void drop(int[][] board)
    {
        
        for(int j = 0; j < board[0].length; ++j)
        {
            int top = board.length-1;
            int now = board.length-1;
            for(int i = top; i >= 0; --i)
            {
                if(board[i][j] != 0)
                {
                    board[now][j] = board[i][j];
                    --now;
                }
            }
            for(int i = now; i >= 0; --i)
            {
                board[i][j] = 0;
            }
        }
    }
    
}

class Solution {
    class Point{
        int val;
        int r;
        int c;
        
        Point(int v, int row, int column)
        {
            val = v;
            r = row;
            c = column;
        }
    };
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        PriorityQueue<Point> help = new PriorityQueue<Point>(new Comparator<Point>(){
            public int compare(Point a, Point b)
            {
                return a.val - b.val;
            }
        });
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); ++i)
        {
            help.offer(new Point(nums.get(i).get(0),i,0));
            max = Math.max(max,nums.get(i).get(0));
        }
        
        int start = help.peek().val;
        int end = max;
        int range = end - start;

        while(true)
        {
            Point tmp = help.poll();
            if(range > max - tmp.val)
            {
                range = max - tmp.val;
                start = tmp.val;
                end = max;
            }
            if(tmp.c == nums.get(tmp.r).size()-1)
            {
                break;
            }
            else
            {
                help.offer(new Point(nums.get(tmp.r).get(tmp.c+1),tmp.r,tmp.c+1));
                max = Math.max(max,nums.get(tmp.r).get(tmp.c+1));
            }
        }
        res[0] = start;
        res[1] = end;
        return res;
    }
}

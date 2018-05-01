class Solution {
    
    class Point{
        int pos;
        int speed;
        
        public Point(int p, int s)
        {
            pos = p;
            speed = s;
        }
        
    };
    public int racecar(int target) {
        if(target == 0) return 0;
        
        Queue<Point> help = new LinkedList<Point>();
        help.offer(new Point(0,1));
        HashSet<String> record = new HashSet<String>();
        record.add("0 1");
        int level = 0;
        
        while(!help.isEmpty())
        {
            int size = help.size();
            for(int i= 0; i < size; ++i)
            {
                Point t = help.poll();
                
                Point ta = new Point(t.pos+t.speed,2*t.speed);
                Point tr = new Point(t.pos,(t.speed > 0)? -1: 1);
                String sa = ta.pos + " " + ta.speed;
                String sr = tr.pos + " " + tr.speed;
                
                if(ta.pos == target)
                {
                    return level+1;
                }
                if(!record.contains(sa) && ta.pos > 0 && ta.pos < 2*target)
                {
                    help.offer(ta);
                    record.add(sa);
                }
                if(!record.contains(sr) && tr.pos > 0 && tr.pos < 2*target)
                {
                    help.offer(tr);
                    record.add(sr);
                }
            }
            ++level;
        }
        return -1;
    }
}
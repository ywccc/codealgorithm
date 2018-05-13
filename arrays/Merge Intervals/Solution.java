/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    class Node
    {
        int val;
        boolean flag;
        
        Node(int v,boolean f)
        {
            val = v;
            flag = f;
        }
    };
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return intervals;
        
        Node[] help = new Node[intervals.size()*2];
        HashSet<Node> record = new HashSet<Node>();
        int pos = 0;
        for(int i = 0; i < intervals.size(); ++i)
        {
            
            Node a = new Node(intervals.get(i).start,true);
            Node b = new Node(intervals.get(i).end,false);
            if(!record.contains(a))
            {
                help[pos++] = a;
                record.add(a);
            }
            if(!record.contains(b))
            {
                help[pos++] = b;
                record.add(b);
            }
        }
        Arrays.sort(help,new Comparator<Node>(){
            
            public int compare(Node a,Node b)
            {
                if(a.val != b.val)
                {
                    return a.val - b.val;
                }
                else if(a.flag == b.flag)
                {
                    return 0;
                }
                else if(a.flag)
                {
                    return -1;
                }
                else return 1;
            }
            
        });
        
        List<Interval> res = new ArrayList<Interval>();
        int count = 0;
        int s = 0;
        int e = 0;
        for(int i = 0; i < help.length; ++i)
        {
            if(count == 0)
            {
                if(i == 0)
                {
                    s = help[i].val;
                    ++count;
                }
                else
                {
                    e = help[i-1].val;
                    res.add(new Interval(s,e));
                    s = help[i].val;
                    ++count;
                }
            }
            else
            {
                if(help[i].flag)
                {
                    ++count;
                }
                else
                {
                    --count;
                }
            }
        }
        res.add(new Interval(s,help[help.length-1].val));
        return res;
        
    }
}

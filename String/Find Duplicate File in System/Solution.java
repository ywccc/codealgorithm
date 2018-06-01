class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String,HashSet<String>> help = new HashMap<String,HashSet<String>>();
        List<List<String>> res = new ArrayList<List<String>>();
        if(paths == null || paths.length == 0) return res;
        for(int i = 0; i < paths.length; ++i)
        {
            String[] tmp = paths[i].split(" +");
            for(int j = 1; j < tmp.length; ++j)
            {
                int index = tmp[j].indexOf('(');
                if(!help.containsKey(tmp[j].substring(index)))
                {
                    help.put(tmp[j].substring(index),new HashSet<String>());
                }
                help.get(tmp[j].substring(index)).add(tmp[0]+"/"+tmp[j].substring(0,index));
            }
        }
        
        for(String key : help.keySet())
        {
            if(help.get(key).size() > 1)
            {
                res.add(new ArrayList<String>(help.get(key)));
            }
        }
        return res;
    }
}

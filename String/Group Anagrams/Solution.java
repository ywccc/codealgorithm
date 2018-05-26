class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String,List<String>> help = new HashMap<String,List<String>>();
        if(strs == null || strs.length == 0) return res;
        for(String ss : strs)
        {
            char[] tmp = ss.toCharArray();
            Arrays.sort(tmp);
            String s = String.valueOf(tmp);
            //System.out.println(s);
            if(!help.containsKey(s)) help.put(s,new ArrayList<String>());
            help.get(s).add(ss);
        }
        for(String s : help.keySet())
        {
            res.add(new ArrayList<String>(help.get(s)));
        }
        return res;
    }
}

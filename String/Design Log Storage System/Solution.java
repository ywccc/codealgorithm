class LogSystem {

    HashMap<String,Integer> help;
    
    public LogSystem() {
        help = new HashMap<String,Integer>();
    }
    
    public void put(int id, String timestamp) {
        help.put(timestamp,id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<Integer>();
        int len = 0;
        switch(gra)
        {
            case "Year":
                len = 4;
                break;
            case "Month":
                len = 7;
                break;
            case "Day":
                len = 10;
                break;
            case "Hour":
                len = 13;
                break;
            case "Minute":
                len = 16;
                break;
            case "Second":
                len = 19;
                break;
        }
        
        for(String tmp : help.keySet())
        {
            if(tmp.substring(0,len).compareTo(s.substring(0,len)) >= 0 && tmp.substring(0,len).compareTo(e.substring(0,len)) <= 0) res.add(help.get(tmp));
        }
        
        return res;
        
    }
}

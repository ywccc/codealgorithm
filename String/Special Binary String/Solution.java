class Solution {
    public String makeLargestSpecial(String S) {
        if(S == null || S.length() == 0) return S;
        List<String> help = new ArrayList<String>();
        Stack<Integer> record = new Stack<Integer>();
        record.push(1);
        int pre = 0;
        for(int i = 1; i < S.length(); ++i)
        {
            if(S.charAt(i) == '0') record.pop();
            else record.push(1);
            if(record.isEmpty())
            {
                help.add(S.substring(pre,i+1));
                pre = i+1;
            }
        }

        String res = "";
        //System.out.println(help.size()); 
        if(help.size() == 1)
        {
            res += "1" + makeLargestSpecial(S.substring(1,S.length()-1)) + "0";
            return res;
        }
        
                
       String[] tmp = new String[help.size()];
        
        for(int i = 0; i < tmp.length; ++i)
        {
            tmp[i] = makeLargestSpecial(help.get(i));
            
        }
        Arrays.sort(tmp,new Comparator<String>(){
            public int compare(String a, String b)
            {
                return b.compareTo(a);
            }
        });
        
        for(int i = 0; i < tmp.length; ++i)
        {
            res += tmp[i];
        }
       
        return res;
    }
    
    public boolean check(List<String> help)
    {
        int len = help.get(0).length();
        for(int i = 1; i < help.size(); ++i)
        {
            if(help.get(i).length() != len) return false;
        }
        return true;
    }
}

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String res = "";
        for(String s : strs)
        {
            int len = s.length();
            res += len + "/" + s;
        }
        return res;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();
        int i = 0;
        while(i < s.length())
        {
            int pre = i;
            while(s.charAt(i)!='/') ++i;
            int len = Integer.valueOf(s.substring(pre,i));
            ++i;
            res.add(s.substring(i,i+len));
            i = i+len;
        }
        return res;
    }
}

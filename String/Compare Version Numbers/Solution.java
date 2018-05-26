class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.equals(version2)) return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while(i < v1.length || i < v2.length)
        {
            int vv1 = (i < v1.length)?Integer.valueOf(v1[i]):0;
            //System.out.println(vv1);
            int vv2 = (i < v2.length)?Integer.valueOf(v2[i]):0;
            if(vv1 < vv2) return -1;
            else if(vv1 > vv2) return 1;
            ++i;
        }
        return 0;
    }
}

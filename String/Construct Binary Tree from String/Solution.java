/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0) return null;
        int i = 0;
        while(i < s.length() && s.charAt(i) != '(') ++i;
        if(i == s.length())
        {
            if(s.charAt(0) == '-')
            {
                return new TreeNode(0-Integer.valueOf(s.substring(1)));
            }
            else
            {
                return new TreeNode(Integer.valueOf(s));
            }
        }
        int count = 1;
        int j = i+1;
        while(j < s.length())
        {
            if(s.charAt(j) == '(') ++count;
            else if(s.charAt(j) == ')') --count;
            if(count == 0) break;
            ++j;
        }
        TreeNode root;
        if(s.charAt(0) == '-')
        {
            root = new TreeNode(0-Integer.valueOf(s.substring(1,i)));
        }
        else
        {
            root = new TreeNode(Integer.valueOf(s.substring(0,i)));
        }
        root.left = (j-1>=i+1)?str2tree(s.substring(i+1,j)):null;
        root.right = (s.length()-2>=j+2)?str2tree(s.substring(j+2,s.length()-1)):null;
        return root;
    }  
}

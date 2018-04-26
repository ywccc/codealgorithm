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
    public List<TreeNode> generateTrees(int n) {
        
        List<TreeNode>[] res = new List[n+1];
        res[0] = new ArrayList<TreeNode>();
        if(n == 0) return res[0];
        
        res[0].add(null);
        
        for(int i = 1; i <= n; ++i)
        {
            res[i] = new ArrayList<TreeNode>();
            for(int j = 0; j < i; ++j)
            {
                for(TreeNode left : res[j])
                {
                    for(TreeNode right : res[i-j-1])
                    {
                        TreeNode root = new TreeNode(j+1);
                        root.left = left;
                        root.right = help(right,j+1);
                        res[i].add(root);
                    }
                }
            }
        }
        return res[n];
        
    }
    
    public TreeNode help(TreeNode root, int n)
    {
        if(root == null) return root;
        
        TreeNode res = new TreeNode(root.val + n);
        res.left = help(root.left,n);
        res.right = help(root.right,n);
        return res;
    }
}
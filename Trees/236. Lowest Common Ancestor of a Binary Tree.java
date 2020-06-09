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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if(root == null)
            return null;
        if(root == p || root == q)
            return root;
        // Look for keys in left and right subtrees
        TreeNode left_Lca = lowestCommonAncestor(root.left, p, q);
        TreeNode right_Lca = lowestCommonAncestor(root.right, p, q);
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_Lca != null && right_Lca != null) {
          return root;
        }
        // Otherwise check if left subtree or right subtree is LCA
        return left_Lca != null ? left_Lca : right_Lca;
    }
}
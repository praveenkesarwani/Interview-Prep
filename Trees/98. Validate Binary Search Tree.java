/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    Stack<Integer> stack = new Stack<>();
    boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        //Inorder Traversal left->root->right
        boolean left_subtree = isValidBST(root.left);
        if(!stack.empty())
            if(root.val <= stack.peek())
                return false;
        stack.push(root.val);
        boolean right_subtree = isValidBST(root.right);
        return left_subtree && right_subtree;
    }
}

//Determine if a given binary tree is a valid BST
/*
// Definition of TreeNode
public class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (long x) {
        val = x;
        left = null;
        right = null;
    }
}
*/
public class Solution {
    Stack<TreeNode> stack = new Stack<>();
    boolean validateBinarySearchTree(TreeNode root) {
        //Base case
        if(root == null)
            return true;
        //Inorder Traversal left->root->right
        boolean left_subtree = validateBinarySearchTree(root.left);
        if(!stack.empty())
            if(root.val <= stack.peek().val)
                return false;
        stack.push(root);
        boolean right_subtree = validateBinarySearchTree(root.right);
        return left_subtree && right_subtree;
    }
}
// Find the first common ancestor of two binary tree nodes
// Definition for TreeNode
/*
class TreeNode {
public:
    long val;
    TreeNode* left;
    TreeNode* right;
    TreeNode* next;
    TreeNode (long x) {
        val = x;
        left = NULL;
        right = NULL;
        next = NULL;
    }
*/

class CommonAncestor {
public:
  TreeNode *commonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
    // Base case
    if (root == NULL) {
      return NULL;
    }
    if (root == p || root == q) {
      return root;
    }
    // Look for keys in left and right subtrees
    TreeNode *left_Lca = commonAncestor(root->left, p, q);
    TreeNode *right_Lca = commonAncestor(root->right, p, q);
    // If both of the above calls return Non-NULL, then one key
    // is present in once subtree and other is present in other,
    // So this node is the LCA
    if (left_Lca && right_Lca) {
      return root;
    }
    // Otherwise check if left subtree or right subtree is LCA
    return left_Lca != NULL ? left_Lca : right_Lca;
  }
};

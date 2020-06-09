/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
  int minDepth(TreeNode *root) {
    if (root == NULL) {
      return 0;
    }
    int leftDepth = minDepth(root->left);
    int rightDepth = minDepth(root->right);
    if (leftDepth == 0 || rightDepth == 0) {
      return 1 + max(leftDepth, rightDepth);
    } else {
      return 1 + min(leftDepth, rightDepth);
    }
  }
};
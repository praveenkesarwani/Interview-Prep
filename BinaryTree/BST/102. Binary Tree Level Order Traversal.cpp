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
  vector<vector<int>> res;
  vector<int> current_res;
  vector<vector<int>> levelOrderTraversal(TreeNode *root) {
    queue<TreeNode *> pendingNodes;
    pendingNodes.push(root);
    pendingNodes.push(NULL);
      
    while (!pendingNodes.empty()) {
      TreeNode *curr = pendingNodes.front();
      pendingNodes.pop();
      if (curr == NULL) 
      {
        res.push_back(current_res);
        current_res.clear();
        if (!pendingNodes.empty())
          pendingNodes.push(NULL);
      } 
      else if (curr) 
      {
        current_res.push_back(curr->val);
        if (curr->left)
          pendingNodes.push(curr->left);
        if (curr->right)
          pendingNodes.push(curr->right);
      }
      else
        break;
    }
      
    return res;
  }
  vector<vector<int>> levelOrder(TreeNode *root) {
    if (root == NULL)
      return res;
    return levelOrderTraversal(root);
  }
};
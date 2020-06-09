/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> ans;
    vector<int> current;
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        //edge case
        if(root == NULL)
            return ans;
        stack<TreeNode*>stack1;
        stack<TreeNode*>stack2;
        stack1.push(root);
        while(!stack1.empty() || !stack2.empty()){
            while(!stack1.empty()){
                TreeNode* top = stack1.top();
                stack1.pop();
                current.push_back(top->val);
                // push left and right child in stack2
                if(top->left)
                    stack2.push(top->left);
                if(top->right)
                    stack2.push(top->right);
            }
            //if it contains values then only add it in ans
            if(current.size() != 0){
                ans.push_back(current);
                current.clear();
            }
             while(!stack2.empty()){
                TreeNode* top = stack2.top();
                stack2.pop();
                current.push_back(top->val);
                // push right and left child in stack1 
                if(top->right)
                    stack1.push(top->right);
                if(top->left)
                    stack1.push(top->left);
            }
            if(current.size() != 0){
                ans.push_back(current);
                current.clear();
            }
        }
        return ans;
    }
};
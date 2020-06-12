/*
// Definition for TreeNode
class TreeNode {
public:
    long val;
    TreeNode* left;
    TreeNode* right;
    TreeNode (long x) {
        val = x;
        left = NULL;
        right = NULL;
    }
};
*/
    stack<TreeNode*> st; 
    int kthSmallest(TreeNode* root, int k) {
        // base case
        if(root == NULL)
            return 0;
        //Inorder traversal left->root->right
        int left = kthSmallest(root->left, k);
        if(st.size() == k)
            return st.top()->val;
        st.push(root);
        int right = kthSmallest(root->right, k);

        return st.top()->val;
        
    }
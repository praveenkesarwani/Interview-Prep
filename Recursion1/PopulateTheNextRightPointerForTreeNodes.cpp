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

class PopulatingNextRightPointersInEachNode {
public:
    TreeNode* populatingNextRightPointersInEachNode(TreeNode* root ) {
    queue<TreeNode*>q;
    q.push(root);
    q.push(NULL);
    while(!q.empty()){
        TreeNode* current = q.front();
        q.pop();
        if(current == NULL && !q.empty()){
            q.push(NULL);
        }
        else if(current){
            current->next = q.front();
            if(current->left){
                q.push(current->left);
            }
            if(current->right){
                q.push(current->right);
            }
        }
    }
    return root;
    }
};

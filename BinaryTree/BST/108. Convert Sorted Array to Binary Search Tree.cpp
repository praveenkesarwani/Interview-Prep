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
class Solution
{
public:
    TreeNode *generateBST(vector<int> &arr, int start, int end)
    {
        //Base case
        if (start > end)
        {
            return NULL;
        }
        int mid = start + (end - start) / 2;
        int rootData = arr[mid];
        TreeNode *root = new TreeNode(rootData);
        root->left = generateBST(arr, start, mid - 1);
        root->right = generateBST(arr, mid + 1, end);
        return root;
    }

    TreeNode *sortedArrayToBST(vector<int> &arr)
    {
        int n = arr.size();
        //startIndex = 0,endIndex = n-1
        return generateBST(arr, 0, n - 1);
    }
};
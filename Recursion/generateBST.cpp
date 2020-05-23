// Create a BST with minimal height from a sorted array
class MinimalTree {
public:
  TreeNode *generateBST(vector<int> &arr, int start, int end) {
    // Base case
    if (start > end) {
      return NULL;
    }
    int mid = start + (end - start) / 2;
    int rootData = arr[mid];
    TreeNode *root = new TreeNode(rootData);
    root->left = generateBST(arr, start, mid - 1);
    root->right = generateBST(arr, mid + 1, end);
    return root;
  }
  TreeNode *findMinimalTree(vector<int> &arr) {
    int n = arr.size();
    return generateBST(arr, 0, n - 1);
  }
};
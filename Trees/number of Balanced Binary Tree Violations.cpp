/*
Find number of Balanced Binary Tree Violations.
Given a binary tree count the total number of balanced binary tree voilations in the given tree.
*/
#include <bits/stdc++.h>
using namespace std;

class TreeNode {

public:
    long val;
    TreeNode* left;
    TreeNode* right;
    TreeNode* next;
    TreeNode* parent;

    TreeNode() {}

    TreeNode (long x) {
        val = x;
        left = NULL;
        right = NULL;
        next = NULL;
        parent = NULL;
    }

    vector<TreeNode*> getTreeFromEdges(int n,vector<int>& value, vector<vector<int> >& edges)
    {
        vector<TreeNode* > nodes;
        for(int i=0;i<n;i++)
        {
            TreeNode* temp = new TreeNode(value[i+1]);
            nodes.push_back(temp);
        }
        for(auto edge: edges)
        {
            int parent = edge[0];
            int leftchild = edge[1];
            int rightchild = edge[2];
            if(leftchild != -1)
                nodes[parent - 1]->left = nodes[leftchild - 1];
            if(rightchild != -1)
                nodes[parent - 1]->right = nodes[rightchild - 1];
        }
        return nodes;
    }
    vector<TreeNode*> readTree()
    {
        // IO
        int n,a,b,x;
        cin >> n;
        if(n==0)
        {
            vector<TreeNode*> answer;
            return answer;
        }
        vector<int > value(n+1,0);
        for (int i = 1; i <= n; i++)
            cin>>value[i];
        vector<vector<int> > edges;
        for(int i=0;i<n;i++)
        {
            cin>>x>>a>>b;
            edges.push_back({x,a,b});
        }
        return getTreeFromEdges(n,value,edges);
    }
    vector<TreeNode*> readTreeReturnAllNodes()
    {
        vector<TreeNode*> nodes = readTree();
        return nodes;
    }

    TreeNode* readTreeReturnRoot()
    {
        vector<TreeNode*> nodes = readTree();
        TreeNode* root = nodes[0];
        return root;
    }
};

//*****************SOLUTION*************************//
int height(TreeNode* root){
    if(root == NULL)
        return 0;
    return 1 + max(height(root->left),height(root->right));
}
void number_of_bt_voilations(TreeNode* root, int &count){
    if(root == NULL)
        return;
    int left_height = height(root->left);
    int right_height = height(root->right);
    if(abs(left_height - right_height) > 1)
        count++;
    number_of_bt_voilations(root->left ,count);
    number_of_bt_voilations(root->right ,count);
}
int main()
{
    TreeNode* root  = TreeNode().readTreeReturnRoot();
    int count = 0;
    number_of_bt_voilations(root, count);
    cout << count << endl;
    return 0;
}
//**************************************************//
import crio.ds.Tree.TreeNode;
import java.util.*;
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
    int preorder_index = 0;
    Map<Integer,Integer> index_lookup = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index = 0;
        for(Integer val:inorder){
            index_lookup.put(val,index++);
        }
        return recursiveTreeBuilder(preorder,inorder,0,inorder.length);
    }
    
    public TreeNode recursiveTreeBuilder(int[] preorder,int[] inorder,
            int inorderStart,int inorderEnd){
        if(inorderStart == inorderEnd){
            return null;
        }
        int rootData = preorder[preorder_index];
        preorder_index++;
        TreeNode root = new TreeNode(rootData);
        int index = index_lookup.get(rootData);
        root.left = recursiveTreeBuilder(preorder,inorder,inorderStart,
        index);
        root.right = recursiveTreeBuilder(preorder,inorder,index+1,inorderEnd);
        return root;
    }
}

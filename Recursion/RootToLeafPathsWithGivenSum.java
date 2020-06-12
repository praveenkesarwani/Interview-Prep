import java.util.*;
import crio.ds.Tree.TreeNode;

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
    long answer = 0;
    long pathsWithSumRootToLeaf(TreeNode root, long k) {
        countPaths(root,k);
        return answer;
    }
    void countPaths(TreeNode root,long k){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(root.val == k){
                answer++;
            }
        }
        countPaths(root.left, k - root.val);
        countPaths(root.right, k - root.val);
    }
}

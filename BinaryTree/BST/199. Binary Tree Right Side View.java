/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer>ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return ans;
        }
        Queue<TreeNode>pendingNodes = new LinkedList<>();
        pendingNodes.add(root);
        pendingNodes.add(null);
        while(!pendingNodes.isEmpty()){
            TreeNode curr = pendingNodes.poll();
            if(pendingNodes.peek() == null && !pendingNodes.isEmpty()){
                ans.add(curr.val);
            }
            if(curr == null && !pendingNodes.isEmpty()){
                pendingNodes.add(null);
            }
            if(curr != null){
                if(curr.left != null)
                    pendingNodes.add(curr.left);
                if(curr.right != null)
                    pendingNodes.add(curr.right);
            }
        }
        return ans;
    }
}
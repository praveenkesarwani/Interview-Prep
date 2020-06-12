
//In-order traversal of a binary tree using a stack
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
    public List<Long> inorderTraversal(TreeNode root) {
      Stack<TreeNode> stack = new Stack<>();
      TreeNode curr = root;
      List<Long> res = new ArrayList<>();
      while(curr != null || !stack.empty()){
        while(curr != null){
          stack.push(curr);
          curr = curr.left;
        }
        curr = stack.pop();
        res.add(curr.val);
        curr = curr.right;
      }
      return res;
    }
  }
  /*
  Time Complexity: O(n), where n is the number of nodes in the tree. This is because every node is visited once.
  Space Complexity: O(n), space needed for the stack in the worst case (unbalanced tree). In the average case it is O(logn).
  */
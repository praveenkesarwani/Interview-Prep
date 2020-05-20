/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/*Recursive*/
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return result;
        }
        for(int i = 0;i < root.children.size();i++){
            postorder(root.children.get(i));
        }
        result.add(root.val);
        return result;
    }
}
/*Iterative*/
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null){
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            root = stack.pop();
            result.add(root.val);
            for(Node node:root.children){
                stack.push(node);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
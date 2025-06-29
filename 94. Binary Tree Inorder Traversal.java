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


    //Recursive Solution
    public List<Integer> inorderTraversal(TreeNode root) {
        // inorder - left root right
        List<Integer> list = new ArrayList<>();
        inOrderHelper(root, list);
        return list;
    }

    void inOrderHelper(TreeNode root,List<Integer> result){

        if(root==null){
            return;
        }

        inOrderHelper(root.left, result);
        result.add(root.val);
        inOrderHelper(root.right, result);
    }

    //Iterative Solution
    public List<Integer> inorderTraversalq(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while(currentNode!=null || !stack.isEmpty()){
            while(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            list.add(currentNode.val);
            currentNode = currentNode.left;
        }

        return list;
    
    }
}
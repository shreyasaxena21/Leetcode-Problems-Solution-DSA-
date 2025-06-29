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

    // Recursive Solution
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderHelper(root, list);
        return list;
    }
    //O(N)
    void preOrderHelper(TreeNode root,List<Integer> result ){
        //base case
        if(root==null){
            return;
        }
        result.add(root.val);
        preOrderHelper(root.left, result);
        // backtrack
        preOrderHelper(root.right, result);

    }

    //Iterative solution using stack
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // emptylist

        if(root==null){
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            list.add(currentNode.val);

            //push the right value first in the stack then push the left in the stack
            if(currentNode.right!=null){
                stack.push(currentNode.right);
            }

            if(currentNode.left!=null){
                stack.push(currentNode.left);
            }


        }

        return list;
    }

}
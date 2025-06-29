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
    //Recursive Approach
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrderHelper(root, list);
        return list;
    }

    void postOrderHelper(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }

        postOrderHelper(root.left, result);
        postOrderHelper(root.right, result);
        result.add(root.val);
    }
}
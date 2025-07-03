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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }

        // first search
        if(key < root.val){
            root.left = deleteNode(root.left, key);

        }

        else if(key>root.val){
            root.right = deleteNode(root.right, key);
        }

        else{
            //case 1 leaf node
            if(root.left==null){
                return root.right;
            }

            if(root.right==null){
                return root.left;
            }
            //case 2 non leaf node
            // element found
            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);

        }

        return root;
    }

    TreeNode findMin(TreeNode node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
}
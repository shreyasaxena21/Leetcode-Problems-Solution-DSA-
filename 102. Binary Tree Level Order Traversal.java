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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Level Order = BFT
        // Queue is needed
        List<List<Integer>> bigList = new ArrayList<>();

        if(root==null){
            return bigList;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> smallList = new ArrayList<>();
            for(int i = 0; i<levelSize; i++){
                TreeNode currentNode = queue.poll();
                smallList.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }

                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }

            bigList.add(smallList);
        }

        return bigList;


    }
}
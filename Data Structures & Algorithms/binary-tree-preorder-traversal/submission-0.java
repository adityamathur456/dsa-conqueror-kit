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
    List<Integer> preorderResult;
    public List<Integer> preorderTraversal(TreeNode root) {
        preorderResult = new ArrayList<>();
        preorderRecur(root);
        return preorderResult;
    }

    private void preorderRecur(TreeNode root) {
        if (root == null) 
            return;
        
        preorderResult.add(root.val);
        preorderRecur(root.left);
        preorderRecur(root.right);
    }
}
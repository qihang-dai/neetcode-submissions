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
    Stack<TreeNode> stack = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        while(stack.size() != k){
            stack.pop();
        }

        return stack.pop().val;
    }

    void dfs(TreeNode root){
        if(root.left == null && root.right == null){
            stack.push(root);
            return;
        }
        if(root.left != null) dfs(root.left);
        stack.push(root);
        if(root.right != null) dfs(root.right);
    }
}

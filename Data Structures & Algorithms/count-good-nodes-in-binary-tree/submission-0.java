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
    int goodResult = 0;
    public int goodNodes(TreeNode root) {
        dfs(root.val, root);
        return goodResult;
    }

    public void dfs(int maxRouteVal, TreeNode cur) {
        if(cur == null) return;
        if(cur.val >= maxRouteVal) goodResult++;
        dfs(Math.max(cur.val, maxRouteVal), cur.left);
        dfs(Math.max(cur.val, maxRouteVal), cur.right);
    }
}

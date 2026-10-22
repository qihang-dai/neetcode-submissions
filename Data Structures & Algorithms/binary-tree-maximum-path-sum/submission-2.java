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
    //pre: traverse node, if null return 0;
    // else for cur node, 
    //      maxleft = Math.max(0, max(node.left))
    //      maxRight = Math.max(0, node.right)
    //      curVal = cur.val + maxLeft + cur.Right
    //      globalMax = Math.max(cur);
    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // if(root == null) return 0;

        // int maxLeft = Math.max(0, maxPathSum(root.left));
        // int maxRight = Math.max(0, maxPathSum(root.right));
        // int curMax = root.val + maxLeft + maxRight;
        // System.out.println(curMax);
        // globalMax = Math.max(globalMax, curMax);
        // return curMax;
        dfs(root);
        return globalMax;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int maxLeft = Math.max(0, dfs(root.left));
        int maxRight = Math.max(0, dfs(root.right));
        int curMax = root.val + maxLeft + maxRight;
        // System.out.println(curMax);
        globalMax = Math.max(globalMax, curMax);
        return root.val + Math.max(maxLeft, maxRight); // can only choose one branch 
    }
}

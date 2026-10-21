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

    // #TODO: claude assited. worth redo

    Map<Integer, Integer> indxInorder = new HashMap<>();
    int preIndx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            indxInorder.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1);
    }

    TreeNode build(int[] pre, int[] in, int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(pre[preIndx++]);
        int mid = indxInorder.get(root.val);
        root.left = build(pre, in, left, mid -1);
        root.right = build(pre, in, mid + 1, right);
        return root;
    }
}

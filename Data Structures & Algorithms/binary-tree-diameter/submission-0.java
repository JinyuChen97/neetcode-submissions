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
    int longest = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        check(root);
        return longest;
    }

    int check(TreeNode node){
        if(node==null) return 0;

        int left = check(node.left);

        int right = check(node.right);

        longest = Math.max(longest,left+right);

        return Math.max(left,right)+1;
    }
}

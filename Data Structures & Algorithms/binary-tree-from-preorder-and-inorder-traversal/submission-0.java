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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

         return dfs(preorder,map,0,inorder.length-1);
    }
    int index = 0;
    public TreeNode dfs(int[] preorder, Map<Integer,Integer> map, int left, int right){
        if(left>right) return null;

        int rootValue = preorder[index++];
        int rootIndex = map.get(rootValue);

        TreeNode root = new TreeNode(rootValue);

        root.left = dfs(preorder,map,left,rootIndex-1);
        root.right = dfs(preorder,map,rootIndex+1,right);

        return root;
    }
}

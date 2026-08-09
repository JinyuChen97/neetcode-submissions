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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    void buildString(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return buildTree(q);
    }

    TreeNode buildTree(Queue<String> q){
        String curr = q.poll();
        if(curr.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(curr));
        node.left=buildTree(q);
        node.right=buildTree(q);
        return node;
    }
}

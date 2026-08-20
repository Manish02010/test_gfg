/* Structure of binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    // Variable to store the maximum difference found
    int max_diff = Integer.MIN_VALUE;

    int maxDiff(Node root) {
        max_diff = Integer.MIN_VALUE;
        dfs(root);
        return max_diff;
    }

    private int dfs(Node node) {
        // Base case: if node is null, return a large value
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        // Base case: if it's a leaf node, it has no descendants
        if (node.left == null && node.right == null) {
            return node.data;
        }

        // Recursively find the minimum value in the left and right subtrees
        int leftMin = dfs(node.left);
        int rightMin = dfs(node.right);

        // The minimum descendant value for the current node
        int minChild = Math.min(leftMin, rightMin);

        // Update the maximum difference (Ancestor - Descendant)
        max_diff = Math.max(max_diff, node.data - minChild);

        // Return the minimum value in the current subtree (including the current node)
        return Math.min(node.data, minChild);
    }
}

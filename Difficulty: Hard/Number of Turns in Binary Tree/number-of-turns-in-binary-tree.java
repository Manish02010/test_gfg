/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    // Helper to find the LCA of nodes p and q
    private Node findLCA(Node root, int p, int q) {
        if (root == null || root.data == p || root.data == q) {
            return root;
        }

        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }

    // Helper to find the path from a node to the target value
    private boolean getPath(Node root, int target, StringBuilder path) {
        if (root == null) return false;
        if (root.data == target) return true;

        // Try left subtree
        path.append('L');
        if (getPath(root.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1); // Backtrack

        // Try right subtree
        path.append('R');
        if (getPath(root.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1); // Backtrack

        return false;
    }

    public int numberOfTurns(Node root, int p, int q) {
        Node lca = findLCA(root, p, q);
        if (lca == null) return -1;

        StringBuilder pathP = new StringBuilder();
        StringBuilder pathQ = new StringBuilder();

        // Get directional paths from LCA to p and q
        getPath(lca, p, pathP);
        getPath(lca, q, pathQ);

        // Construct the full sequential movement path from p to q
        StringBuilder fullPath = new StringBuilder();

        // Moving up from p to LCA reverses the path directions
        fullPath.append(pathP.reverse()); 
        // Moving down from LCA to q maintains the original path directions
        fullPath.append(pathQ);

        // Count direction changes (turns)
        int turns = 0;
        for (int i = 0; i < fullPath.length() - 1; i++) {
            if (fullPath.charAt(i) != fullPath.charAt(i + 1)) {
                turns++;
            }
        }

        // If no turns are involved (nodes are on the same straight line path)
        return (turns == 0) ? -1 : turns;
    }
}

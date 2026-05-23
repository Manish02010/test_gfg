/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public void toSumTree(Node root) {
        transform(root);
    }
    
    private int transform(Node root) {
        // Base case: empty node contributes 0 to the sum
        if (root == null) {
            return 0;
        }
        
        // Store the old value of the current node
        int oldValue = root.data;
        
        // Recursively compute the sum of left and right subtrees
        int leftSum = transform(root.left);
        int rightSum = transform(root.right);
        
        // Update current node's value to the sum of its subtrees
        root.data = leftSum + rightSum;
        
        // Return the total sum of this subtree to the parent
        return root.data + oldValue;
    }
}

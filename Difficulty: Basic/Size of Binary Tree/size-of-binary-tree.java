/*
Definition for Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    public int getSize(Node root) {
        // Base case: if the tree is empty
        if (root == null) {
            return 0;
        }
        
        // Recursive step: 1 (current node) + left size + right size
        return 1 + getSize(root.left) + getSize(root.right);
    }
}

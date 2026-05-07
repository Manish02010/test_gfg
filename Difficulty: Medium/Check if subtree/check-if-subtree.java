/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    // Renamed from isSubtree to isSubTree to match the caller
    public boolean isSubTree(Node root1, Node root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;

        if (isIdentical(root1, root2)) return true;

        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    private boolean isIdentical(Node r1, Node r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;

        return (r1.data == r2.data) && 
               isIdentical(r1.left, r2.left) && 
               isIdentical(r1.right, r2.right);
    }
}


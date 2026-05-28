/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
import java.util.ArrayList;
import java.util.TreeMap;

class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // TreeMap keeps the horizontal distances automatically sorted
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // Traverse the tree and populate the map
        calculateSum(root, 0, map);
        
        // Add all sorted vertical sums to the result list
        for (int sum : map.values()) {
            result.add(sum);
        }
        
        return result;
    }
    
    private void calculateSum(Node node, int hd, TreeMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        
        // Add the current node's value to its vertical line sum
        map.put(hd, map.getOrDefault(hd, 0) + node.data);
        
        // Recur for left and right subtrees
        calculateSum(node.left, hd - 1, map);
        calculateSum(node.right, hd + 1, map);
    }
}

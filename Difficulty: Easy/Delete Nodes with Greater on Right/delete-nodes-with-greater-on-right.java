/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    // Helper method to reverse the linked list in-place
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    Node compute(Node head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Reverse the linked list to look from right to left
        head = reverse(head);
        
        // Step 2: Delete nodes smaller than the maximum seen so far
        Node curr = head;
        Node maxNode = head;
        
        while (curr != null && curr.next != null) {
            if (curr.next.data < maxNode.data) {
                // Skip/delete the next node because a greater node exists to its right
                curr.next = curr.next.next;
            } else {
                // Update current and the maximum node seen
                curr = curr.next;
                maxNode = curr;
            }
        }
        
        // Step 3: Reverse the list back to restore original relative order
        return reverse(head);
    }
}

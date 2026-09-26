/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

public class Solution {    
    public ListNode MergeKLists(ListNode[] lists) {
        if (lists == null || lists.Length == 0) return null;
        
        // Min-Heap stores the node itself as the element, and the node's value as the priority
        PriorityQueue<ListNode, int> minHeap = new PriorityQueue<ListNode, int>();
        
        // Push the head of each non-empty linked list into the min-heap
        foreach (var list in lists) {
            if (list != null) {
                minHeap.Enqueue(list, list.val);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Extract the minimum node and push its next element into the heap
        while (minHeap.Count > 0) {
            ListNode smallestNode = minHeap.Dequeue();
            current.next = smallestNode;
            current = current.next;
            
            if (smallestNode.next != null) {
                minHeap.Enqueue(smallestNode.next, smallestNode.next.val);
            }
        }
        
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode secondHalves;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        secondHalves = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(secondHalves != null){ 
        ListNode nextSecond = secondHalves.next; // assign nextSecond to the secondHalves next
        secondHalves.next = prev; //reverse the second halves next to the prev which is null
        prev = secondHalves; // shift the prev where secondhalve is
        secondHalves = nextSecond; // move the second halves to the listnode nextSecond
        }
      
        while (prev != null){
            ListNode newHead = head.next;
        ListNode newPrev = prev.next;
            head.next = prev;
            prev.next = newHead;
            prev = newPrev;
            head = newHead;
        }
    }
}

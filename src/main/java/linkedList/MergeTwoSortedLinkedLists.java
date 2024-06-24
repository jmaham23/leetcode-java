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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while(list1 != null || list2 != null){
            if(list1 == null || (list2 != null && list2.val <= list1.val)){
                curr.next = list2;
                list2 = list2.next;
            }
            else{
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        return head.next;
    }
}
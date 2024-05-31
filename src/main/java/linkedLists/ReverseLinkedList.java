class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode prev, ListNode curr){
        if(curr == null){
            return prev;
        }
        ListNode temp = curr.next;
        curr.next = prev;
        return reverse(curr, temp);
    }
}
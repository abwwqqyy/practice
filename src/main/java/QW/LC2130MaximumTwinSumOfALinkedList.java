package QW;

public class LC2130MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = new ListNode(0);
        slow.next = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        ListNode rHead = reverse(second);
        ListNode cur = head;
        int max = 0;
        while(cur != null){
            max = Math.max(max, cur.val + rHead.val);
            // System.out.println(cur.val + "  " + rHead.val);
            rHead = rHead.next;
            cur = cur.next;
        }
        return max;
    }
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = head.next;
        ListNode next = mid.next;
        mid.next = head;
        head.next = null;
        while(next != null){

            head = mid;
            mid = next;
            next = next.next;
            mid.next = head;
        }
        return mid;
    }
}
// time O(n) space O(1)

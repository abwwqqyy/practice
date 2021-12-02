package QW;

public class LC328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while(odd != null && even != null){
            odd.next = even.next;
            if(odd.next == null){
                odd.next = evenHead;
                even = even.next;
            }else{
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
        }
        odd.next = evenHead;

        return head;
    }
}

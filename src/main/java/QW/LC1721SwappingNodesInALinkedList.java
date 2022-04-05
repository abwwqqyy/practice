package QW;

public class LC1721SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        if(k > count - k + 1) k = count - k + 1;
        if(count == 1 || k == count - k + 1){
            return head;
        }


        ListNode prev1 = new ListNode();
        prev1.next = head;
        ListNode next1 = head.next;
        cur = head;
        int index = 1;
        while(index < k){
            prev1 = cur;
            next1 = cur.next.next;
            cur = cur.next;
            index++;
        }
        // System.out.println(cur.val + " " + index);
        ListNode prev2 = cur;
        ListNode next2 = next1.next;
        while(index < count - k + 1){
            prev2 = cur;
            next2 = cur.next.next;
            cur = cur.next;
            index++;
        }
        // System.out.println(cur.val + " " + index);
        //next to each other swap
        if(k == count - k){
            cur.next = prev1.next;
            prev1.next.next = next2;
            prev1.next = cur;
            if(k == 1) return cur;
            return head;
        }
        //normal swap
        prev2.next = prev1.next;
        prev1.next.next = next2;

        prev1.next = cur;
        cur.next = next1;

        if(k == 1) return cur;
        return head;
    }
}

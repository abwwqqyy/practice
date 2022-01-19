package QW;

import java.util.HashSet;
import java.util.Set;

public class LC142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
// time O(n) space O(n)
// there is a space O(1) way
//
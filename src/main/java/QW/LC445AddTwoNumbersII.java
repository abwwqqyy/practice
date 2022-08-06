package QW;

public class LC445AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int n1 = 0;
        int n2 = 0;
        while(cur1 != null){
            cur1 = cur1.next;
            n1++;
        }
        while(cur2 != null){
            cur2 = cur2.next;
            n2++;
        }
        cur1 = l1;
        cur2 = l2;
        ListNode head = null;
        while(cur1 != null && cur2 != null){
            int curVal = 0;
            if(n1 > n2){
                curVal = cur1.val;
                cur1 = cur1.next;
                n1--;
            }else if(n1 < n2){
                curVal = cur2.val;
                cur2 = cur2.next;
                n2--;
            }else{
                curVal = cur1.val + cur2.val;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            ListNode curNode = new ListNode(curVal); // add to front
            curNode.next = head;
            head = curNode;
        }
        int carry = 0;
        ListNode ptr = head;
        head = null;
        while(ptr != null){
            int val = (ptr.val + carry) % 10;
            carry = (ptr.val + carry) / 10;
            ListNode cur = new ListNode(val); // add to front
            cur.next = head;
            head = cur;
            ptr = ptr.next;
        }
        if(carry != 0){
            ListNode cur = new ListNode(carry);
            cur.next = head;
            head = cur;
        }
        return head;
    }
}
// time O(n) space O(1)

import java.util.*;

public class LinkedLists {
    public ListNode deleteDups1(ListNode head) {
        /*
        Use extra space: O(N)
        */
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode cur = head, previous = head;
        while(cur != null) {
            if(!set.contains(cur.val)) {
                set.add(cur.val);
                previous = cur;
            } else {
                previous.next = cur.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDups2(ListNode head) {
        /*
        O(1) space, O(N^2) time
        */
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode pre = cur, tmp = cur.next;
            while(tmp != null) {
                if(cur.val == tmp.val) {
                    pre.next = tmp.next;
                } else {
                    pre = tmp;
                }
                tmp = tmp.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode nthToLast(ListNode head, int n) {
        /*
        Returns null if head is null or n > length of list or n <= 0
        */
        if(head == null || n <= 0) {
            return null;
        }
        ListNode p1 = head, p2 = head;
        while(p2 != null && n > 0) {
            p2 = p2.next;
            n--;
        }
        if(n != 0) return null;
        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public void deleteNodeInTheMiddle(ListNode node) {
        /*
        The node can't be the tail of the list
        */
        node.val = node.next.val;
        node.next = node.next.next;
        return;
    }
}

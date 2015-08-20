import java.util.*;

public class LinkedLists {
    public ListNode deleteDups(ListNode head) {
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
}

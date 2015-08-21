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
        while(cur != null) {
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

    public ListNode addLists(ListNode l1, ListNode l2) {
        /*
        Add to numbers represented in Integer lists
        */
        return addListsWithCarry(l1, l2, 0);
    }

    public ListNode addListsWithCarry(ListNode l1, ListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int val = carry;
        if(l1 != null) {
            val += l1.val;
        }
        if(l2 != null) {
            val += l2.val;
        }
        ListNode res = new ListNode(val % 10);
        res.next = addListsWithCarry(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val / 10);
        return res;
    }

    public ListNode reverseList_iterative(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode first = head;
        while(first.next != null) {
            ListNode temp = first.next;
            first.next = temp.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }

    public ListNode reverseList_recursive(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList_recursive(nextNode);
        head.next = null;
        nextNode.next = head;
        return newHead;
    }

    public ListNode findBeginning(ListNode head) {
        /*
        Imput: a circled list
        Objective: find the begining of the loop
        Method: TWO POINTERS
        */
        ListNode fast = head, slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                break;
            }
        }
        //check if it's a circled list
        if(fast.next == null) {
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

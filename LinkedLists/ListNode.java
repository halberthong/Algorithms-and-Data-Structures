public class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }

    public void add(int val) {
        ListNode cur = this;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
    }

    public void add(ListNode node) {
        ListNode cur = this;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    @Override
    public String toString() {
        ListNode cur = this;
        StringBuilder res = new StringBuilder();
        while (cur != null) {
            res.append(cur.val);
            res.append(" ");
            cur = cur.next;
        }
        return res.toString();
    }

    public String listToString() {
        String res = "" + this.val;
        if(this.next != null) {
            res += "-" + this.next.listToString(10);
            return res;
        } else {
            return res;
        }
    }

    public String listToString(int limit) {
        if(limit > 0) {
            String res = "" + this.val;
            if(this.next != null) {
                res += "-" + this.next.listToString(limit - 1);
                return res;
            } else {
                return res;
            }
        } else {
            return "...";
        }

    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof ListNode) {
            ListNode li = (ListNode) object;
            return equalsHelper(this, li);
        }
        return false;
    }

    private boolean equalsHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return true;
        } else if (l1 != null && l2 != null && l1.val == l2.val) {
            return equalsHelper(l1.next, l2.next);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.val;
    }

}

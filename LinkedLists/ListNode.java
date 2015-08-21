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
        String res = "" + this.val;
        return res;
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
            if(this == object) {
                return true;
            }
            ListNode node = (ListNode) object;
            if(node.val == this.val) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.val;
    }

}

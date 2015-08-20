public class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }

    ListNode(int x) {
        val = x;
    }

    public void add(int x) {
        this.next = new ListNode(x);
    }

    @Override
    public String toString() {
        String res = "" + this.val;
        if(this.next != null) {
            res += "-" + this.next.toString();
            return res;
        } else {
            return res;
        }
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof ListNode) {
            ListNode node = (ListNode) object;
            if(node.val == this.val) {
                if(node.next != null && this.next != null) {
                    return this.next.equals(node.next);
                } else if(node.next == null && this.next == null) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}

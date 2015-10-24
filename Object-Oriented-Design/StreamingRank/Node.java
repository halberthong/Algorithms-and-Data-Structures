public class Node {
    String name;
    int val;
    Node prev;
    Node next;
    public Node(String n, int v) {
        this.name = n;
        this.val = v;
    }
    public Node() {
        name = "";
        val = 0;
    }
    public void add(int v) {
        this.val += v;
    }
}

import java.util.*;

public class CharacterFreqRank {
    Map<Character, Node> map = new HashMap();
    Node head;
    Node tail;
    public CharacterFreqRank(String s) {
        head = new Node('0');
        tail = new Node('0');
        head.next = tail;
        tail.prev = head;
        run(s);
    }
    class Node {
        char c;
        int count;
        Node next;
        Node prev;
        public Node(char in) {
            this.c = in;
        }
    }
    private void run(String s) {
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Node cur = map.get(c);
                cur.count += 1;
                moveNode(cur);
            } else {
                Node cur = new Node(c);
                cur.count = 1;
                map.put(c, cur);
                addToTail(cur);
            }
        }
    }
    private void moveNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        Node scan = node.prev;
        while (scan != head && scan.count < node.count) {
            scan = scan.prev;
        }
        scan.next.prev = node;
        node.next = scan.next;
        node.prev = scan;
        scan.next= node;
    }
    private void addToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        node.prev.next = node;
    }
    public void print() {
        Node scan = head.next;
        while (scan != tail) {
            System.out.print(scan.c + "\t");
            scan = scan.next;
        }
    }
}

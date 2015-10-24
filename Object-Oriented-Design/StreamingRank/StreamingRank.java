import java.util.*;

public class StreamingRank {
    HashMap<String, Node> map;
    Node head, tail;
    public StreamingRank() {
        map = new HashMap<String, Node>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    public void add(String name, int quantity) {
        if (!map.containsKey(name)) {
            Node newNode = new Node(name, quantity);
            addToList(newNode);
            map.put(name, newNode);
        } else {
            Node node = map.get(name);
            node.add(quantity);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addToList(node);
        }
    }
    public void addToList(Node node) {
        Node scan = head;
        while (scan.next.val > node.val) {
            scan = scan.next;
        }
        node.next = scan.next;
        scan.next = node;
        node.prev = scan;
        node.next.prev = node;
    }
    public void printList() {
        Node scan = head.next;
        while (scan != tail) {
            print(scan.name + " " + scan.val);
            scan = scan.next;
        }
    }
    private void print(Object input) {
		if (input == null) {
			System.out.println("null");
			return;
		}
		System.out.println(input.toString());
	}
}

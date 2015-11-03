import java.util.*;

public class ZigZagIterator {
    List<Iterator<Integer>> iters;
    Queue<Integer> queue;
    public ZigZagIterator(List<Iterator<Integer>> iterators) {
        iters = iterators;
        queue = new LinkedList<Integer>();
    }
    public boolean hasNext() {
        if (queue.size() == 0) {
            addQueue();
            if (queue.size() == 0) {
                return false;
            }
        }
        return true;
    }
    public Integer next() {
        if (queue.size() == 0) {
            addQueue();
        }
        return queue.poll();
    }
    private void addQueue() {
        for (Iterator<Integer> iter : iters) {
            if (iter.hasNext()) {
                queue.add(iter.next());
            }
        }
    }
}

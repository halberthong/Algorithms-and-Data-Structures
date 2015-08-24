import java.util.*;

public class Tower {
    /*
    Implement the Tower of Hanoi
    */
    private Stack<Integer> disks;
    private int index;
    public Tower(int i) {
        disks = new Stack<Integer>();
        index = i;
    }
    public int index() {
        return this.index;
    }
    public Stack<Integer> getDisks() {
        return this.disks;
    }
    public void add(int d) {
        if (!disks.empty() && disks.peek() < d) {
            System.out.println("Error: Can not place disk: " + d + "on the top");
        } else {
            disks.push(d);
        }
    }
    public void moveTopTo(Tower t) {
        if (disks.empty()) {
            System.out.println("Error: Tower is empty");
        } else {
            int top = disks.pop();
            t.add(top);
            System.out.println("Move disk: " + top + " from Tower " + this.index() + " to Tower " + t.index());
        }
    }
    public void moveDisks(int n, Tower dest, Tower buffer) {
        //Where the recursion magic happens
        if (n > 0) {
            moveDisks(n - 1, buffer, dest);
            moveTopTo(dest);
            buffer.moveDisks(n - 1, dest, this);
        }
    }
    public void print() {
        System.out.println("Content of Tower:");
        for(int i = disks.size() - 1; i >= 0; i--) {
            System.out.println(" " + disks.get(i));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Tower) {
            Tower t = (Tower) obj;
            if(this.index == t.index() && this.disks.size() == t.getDisks().size()) {
                for(int i = this.disks.size() - 1; i >= 0; i--) {
                    if(this.disks.get(i) != t.getDisks().get(i)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

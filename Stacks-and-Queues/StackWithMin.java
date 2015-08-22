import java.util.Stack;
import java.lang.Integer;

public class StackWithMin extends Stack<Integer> {
    Stack<Integer> minStack;
    public StackWithMin() {
        minStack = new Stack<Integer>();
    }
    public int min() {
        if(minStack.empty()) {
            return (int)Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }

    public void push(int x) {
        super.push(x);
        if(this.min() > x) {
            minStack.push(x);
        }
    }

    @Override
    public Integer pop() {
        int val = super.pop();
        if(val == this.min()) {
            minStack.pop();
        }
        return val;
    }
}

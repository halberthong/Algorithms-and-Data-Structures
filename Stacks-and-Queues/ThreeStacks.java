import java.util.*;

public class ThreeStacks {

    class StackNode {
        int pre;
        int val;
        public StackNode(int p, int x) {
            this.pre = p;
            this.val = x;
        }
    }

    final int stackSize = 300;
    StackNode[] buffer = new StackNode[3 * stackSize];
    int[] stackPointer = {-1, -1, -1};
    int validIndex = 0;

    public void push(int stackNum, int value) {
        if(validIndex < stackSize * 3) {
            StackNode node = new StackNode(stackPointer[stackNum], value);
            buffer[validIndex] = node;
            stackPointer[stackNum] = validIndex;
            validIndex = Math.max(stackPointer[0], Math.max(stackPointer[1], stackPointer[2])) + 1;
        } else {
            System.out.println("Stack Overflow!");
        }
    }
    public int pop(int stackNum) {
        if(stackPointer[stackNum] == -1) {
            System.out.println("The stack is empty!");
            return 0;
        } else {
            int lastIndex = stackPointer[stackNum];
            StackNode temp = buffer[stackPointer[stackNum]];
            stackPointer[stackNum] = temp.pre;
            buffer[lastIndex] = null;
            validIndex = lastIndex;
            return temp.val;
        }
    }
}

package Stack.StackImplementations;

import java.util.EmptyStackException;

/**
 * This implementation of Stack allows us to get the minimum element in O(1) time,
 * by maintaining a separate minStack.
 */
public class AdvancedStack extends LinkedStack {
    private LinkedStack elementStack = new LinkedStack();
    private LinkedStack minStack = new LinkedStack();

    @Override
    public void push(int data) {
        elementStack.push(data);
        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        }
    }

    @Override
    public int pop() throws EmptyStackException {
        if (elementStack.isEmpty())
            return Integer.MIN_VALUE;
        if (minStack.peek() == elementStack.peek())
            minStack.pop();
        return elementStack.pop();
    }

    public int getMinimum() {
        return minStack.peek();
    }

    public int peek() {
        return elementStack.peek();
    }

    public boolean isEmpty() {
        return elementStack.isEmpty();
    }
}

package Stack.StackImplementations;

public class FixedSizeStack {
    protected int top;
    protected final int capacity;
    protected int[] stack;

    public FixedSizeStack(int capacity) {
        this.capacity = capacity;
        top = -1;
        stack = new int[capacity];
    }

    public int size() {
        return (top + 1);
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return capacity == (top + 1);
    }

    public void push(int data) throws Exception {
        if (isFull())
            throw new Exception("Stack Overflow");
        stack[++top] = data;
    }

    public int pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack Underflow");
        int data = stack[top];
        stack[top--] = Integer.MIN_VALUE;
        return data;
    }

    public int peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack Underflow");
        return stack[top];
    }

    @Override
    public String toString() {
        if (top < 0 )
            return "NO ELEMENTS IN STACK";
        StringBuilder sb = new StringBuilder("Stack Elements: [ ");
        sb.append(stack[0]);
        for (int i = 1; i < size(); i++) {
            sb.append(", ").append(stack[i]);
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        FixedSizeStack stack = new FixedSizeStack(4);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.pop();
            System.out.println(stack.peek());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(stack);
    }
}

package Stack.StackImplementations;

import LinkedList.LLImplementations.ListNode;

import java.util.EmptyStackException;

public class LinkedStack<T> {
    private int length;
    private ListNode top;

    public LinkedStack() {
        this.length = 0;
        this.top = null;
    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        int data = top.data;
        top = top.next;
        length--;
        return data;
    }

    public int peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    @Override
    public String toString() {
        if (top == null )
            return "NO ELEMENTS IN STACK";
        StringBuilder sb = new StringBuilder("Stack Elements: [ ");
        ListNode cur = top;
        while (cur != null) {
            sb.append(cur.data).append(", ");
            cur = cur.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        System.out.println(linkedStack);
        System.out.println(linkedStack.peek());
        linkedStack.pop();
        System.out.println(linkedStack);
    }
}

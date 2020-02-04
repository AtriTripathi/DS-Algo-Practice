package Queue.QueueImplementations;

import LinkedList.LLImplementations.ListNode;

public class LinkedQueue {
    private int length;
    private ListNode front, rear;

    public LinkedQueue() {
        length = 0;
        front = rear = null;
    }

    public void enQueue(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty())
            front = newNode;
        else
            rear.next = newNode;
        rear = newNode;
        length++;
    }

    public int deQueue() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        int data = front.data;
        front = front.next;
        length--;
        if (isEmpty())
            rear = null;
        return data;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int size() {
        return length;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "NO ELEMENTS IN QUEUE";
        StringBuilder sb = new StringBuilder("Queue Elements are: [ ");
        ListNode cur = front;
        while (cur.next != null) {
            sb.append(cur.data).append(", ");
            cur = cur.next;
        }
        sb.append(cur.data).append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enQueue(1);
        linkedQueue.enQueue(2);
        linkedQueue.enQueue(3);
        linkedQueue.deQueue();
        linkedQueue.enQueue(4);
        System.out.println(linkedQueue);
    }
}

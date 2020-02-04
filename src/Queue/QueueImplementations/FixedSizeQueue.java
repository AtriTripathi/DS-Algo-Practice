package Queue.QueueImplementations;

public class FixedSizeQueue {
    private int[] queue;
    private int front, rear, size;
    private int capacity;

    public FixedSizeQueue(int capacity) {
        queue = new int[capacity];
        front = rear = size = 0;
        this.capacity = capacity;
    }

    public void enQueue(int data) throws IllegalStateException {
        if (size == capacity)
            throw new IllegalStateException("Queue Overflow");
        else {
            size++;
            queue[rear] = data;
            rear = (rear + 1) % capacity;
        }
    }

    public int deQueue() throws IllegalStateException {
        if (size == 0)
            throw new IllegalStateException("Queue Underflow");
        else {
            size--;
            int data = queue[front];
            queue[front] = Integer.MIN_VALUE;
            front = (front + 1) % capacity;
            return data;
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "NO ELEMENTS IN QUEUE";
        StringBuilder sb = new StringBuilder("Queue Elements are: [ ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            sb.append(queue[index]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        FixedSizeQueue queue = new FixedSizeQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.deQueue();
        System.out.println(queue);
    }
}

package LinkedList.LLImplementations;

public class CircularLinkedList {
    int length;
    CLLNode tail;

    public CircularLinkedList() {
        length = 0;
        tail = null;
    }

    public void insertAtBegin(int data) {
        addToHead(data);
    }

    private void addToHead(int data) {
        CLLNode newNode = new CLLNode(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        length++;
    }

    public void insertAtEnd(int data) {
        addToHead(data);
        tail = tail.next;
    }

    public int removeAtBegin() {
        if (tail == null) {
            return Integer.MIN_VALUE;
        } else if (tail.next == tail) {
            tail = null;
            return Integer.MIN_VALUE;
        }
        CLLNode temp = tail.next;
        tail.next = temp.next;
        temp.next = null;
        length--;
        return temp.data;
    }

    public int removeAtEnd() {
        if (tail == null)
            return Integer.MIN_VALUE;
        else if (tail.next == tail) {
            tail = null;
            return Integer.MIN_VALUE;
        }
        CLLNode cur = tail.next;
        CLLNode temp = null;
        while (cur != tail) {
            temp = cur;
            cur = cur.next;
        }
        temp.next = cur.next;
        cur.next = null;
        tail = temp;
        length--;
        return cur.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CircularLL: [ ");
        if (tail == null) {
            return sb.append("NO ELEMENTS IN THE LIST ]").toString();
        }
        CLLNode cur = tail.next;
        while (cur != tail) {
            sb.append(cur.data).append(" -> ");
            cur = cur.next;
        }
        sb.append(cur.data).append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtBegin(1);
        cll.insertAtEnd(2);
        cll.insertAtBegin(3);
        cll.insertAtEnd(4);
        cll.removeAtBegin();
        System.out.println(cll);
    }
}

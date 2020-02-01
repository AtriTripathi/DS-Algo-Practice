package LinkedList.LLImplementations;

/**
 * NOTE: Implementation is incomplete (Code doesn't work properly)
 */
public class DoublyLinkedList {
    int length;
    DLLNode head;
    DLLNode tail;

    // NOTE: Here, head and tail are regular nodes and store random data only to indicate the ends of the list
    public DoublyLinkedList() {
        length = 0;
        head = new DLLNode(Integer.MIN_VALUE,null,null);
        tail = new DLLNode(Integer.MIN_VALUE, head,null);
        head.next = tail;
    }

    public void insertAtBegin(int data) {
        DLLNode newNode = new DLLNode(data, null, head.next);
        head.next.prev = newNode;
        head = newNode;
        length++;
    }

    public void insertAtEnd(int data) {
        DLLNode newNode = new DLLNode(data,tail.prev,tail);
        newNode.prev.next = newNode;
        tail.prev = newNode;
        length++;
    }

    public DLLNode removeAtBegin() {
        if (head == null)
            return null;
        if (head.next == null) {
            length--;
            return head;
        }
        DLLNode temp = head;
        head.next.prev = null;
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nList: [ ");
        DLLNode cur = head;
        if (head == null) {
            sb.append("NO ELEMENTS IN THE LIST ]");
            return sb.toString();
        }
        while (cur.next != null) {
            sb.append(cur.data).append(" -> ");
            cur = cur.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList dLinkedList = new DoublyLinkedList();
        dLinkedList.insertAtBegin(1);
        dLinkedList.insertAtBegin(2);
        System.out.println(dLinkedList);
//        dLinkedList.removeAtBegin();
//        System.out.println(dLinkedList);

    }
}
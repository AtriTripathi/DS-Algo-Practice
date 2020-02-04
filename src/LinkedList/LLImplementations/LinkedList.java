package LinkedList.LLImplementations;

public class LinkedList {
    public int length;
    public ListNode head;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public void insertAtBegin(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode cur = head;
            while (cur.next != null)
                cur = cur.next;
            cur.next = newNode;     // Note here, that cur.next should point at newNode, and not cur itself.
        }
        length++;
    }

    public void insertAtPosition(int data, int position){
        ListNode newNode = new ListNode(data);
        if (position < 0)
            position = 0;
        if (position > length)
            position = length;
        if (head == null)
            head = newNode;
        else if (position == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            ListNode cur = head;
            for (int i = 1; i < position; i++) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
        length++;
    }

    public ListNode removeAtBegin() {
        ListNode temp = head;
        if (head != null) {
            head = head.next;
            temp.next = null;   // Frees the node object for GC
        }
        length--;
        return temp;
    }

    public ListNode removeAtEnd() {
        if (head == null)
            return null;
        ListNode cur = head;
        ListNode temp = head;
        if (head.next == null) {    // This check is very important
            head = null;
            return cur;
        }
        while (cur.next != null) {
            temp = cur;
            cur = cur.next;
        }
        temp.next = null;
        length--;
        return cur;
    }

    public void removeMatched(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            length--;
            return;
        }
        ListNode cur = head;
        ListNode temp;
        while (cur.next != null) {
            temp = cur;
            cur = cur.next;
            if (cur.data == data) {
                temp.next = cur.next;
                length--;
                return;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nList: [ ");
        ListNode cur = head;
        if (head == null) {
            sb.append("NO ELEMENTS IN THE LIST ]");
            return sb.toString();
        }
        while (cur != null) {
            sb.append(cur.data).append(" -> ");
            cur = cur.next;
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtBegin(1);
        linkedList.insertAtEnd(2);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(4);
        linkedList.insertAtEnd(5);
        linkedList.insertAtEnd(6);
        linkedList.removeMatched(6);
        linkedList.removeAtEnd();

//        ListNode nthNodeFromEnd = linkedList.nthNodeFromEnd.NthNodeFromEnd(linkedList.head,3);
//        System.out.println(nthNodeFromEnd.data);

        System.out.println(linkedList.toString());
    }
}

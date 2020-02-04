package LinkedList.LLAlgorithms;

import LinkedList.LLImplementations.LinkedList;
import LinkedList.LLImplementations.ListNode;

public class LinkedListAlgos {

    public int counter = 0;

    public ListNode NthNodeFromEnd(ListNode head, int nthNode) {
        ListNode ptemp = head;
        ListNode pNthNode = null;
        for (int i = 1; i < nthNode; i++) {
            if (ptemp != null)
                ptemp = ptemp.next;
        }
        while (ptemp != null) {
            if (pNthNode == null)
                pNthNode = head;
            else
                pNthNode = pNthNode.next;
            ptemp = ptemp.next;
        }
        if (pNthNode != null)
            return pNthNode;
        return null;
    }

    public ListNode NthNodeFromEndRecursive(ListNode head, int nthNode) {
        if (head != null) {
            NthNodeFromEndRecursive(head.next,nthNode);
            counter++;
            if (counter == nthNode) {
                return head;
            }
        }
        return null;
    }

    public boolean findIfLoopExistsUsingFloyds(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    public ListNode findBeginOfLoop(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        boolean loopExists = false;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
            return fastPtr;
        }
        return null;
    }

    public ListNode reverseListIterative(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        if (head == null)
            return null;

        while (cur != null) {
            ListNode temp = cur.next;   // Save the next node at each iteration
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public ListNode findIntersectingNode(ListNode list1, ListNode list2) {
        int L1 = 0, L2 = 0, diff = 0;
        ListNode head1 = list1, head2 = list2;

        while (head1 != null) {
            L1++;
            head1 = head1.next;
        }

        while (head2 != null) {
            L2++;
            head2 = head2.next;
        }

        if (L1 < L2) {
            head1 = list2;
            head2 = list1;
            diff = L2 - L1;
        } else if (L1 > L2) {
            head1 = list1;
            head2 = list2;
            diff = L1 - L2;
        }

        for (int i = 0; i < diff; i++) {
            head1 = head1.next;
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2)
                return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null)
            cur.next = head1;
        else if (head2 != null)
            cur.next = head2;
        return head.next;
    }

    /*
    NOT WORKING YET
     */
    public boolean checkPalindrome(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        boolean isPalindrome = true;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        ListNode firstHead = head;
        ListNode secondHead = slowPtr.next;
        secondHead = reverseListIterative(secondHead);
        ListNode auxSecondHead = secondHead;
        slowPtr.next = null;

        while (firstHead != null && secondHead != null) {
            if (firstHead.data != secondHead.data) {
                isPalindrome = false;
                break;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }

        // Join back the original list
        auxSecondHead = reverseListIterative(auxSecondHead);
        slowPtr.next = auxSecondHead;
        return isPalindrome;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtBegin(1);
        linkedList.insertAtEnd(2);
//        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(3);
        linkedList.insertAtEnd(1);

        System.out.println(linkedList);
        LinkedListAlgos linkedListAlgos = new LinkedListAlgos();

        boolean isPalindrome = linkedListAlgos.checkPalindrome(linkedList.head);
        System.out.println("Check if the list is palindrome: " + isPalindrome);

        // Reset the head with the reversed list
        linkedList.head = linkedListAlgos.reverseListIterative(linkedList.head);
        System.out.println("Reversed List" + linkedList);

        ListNode nth = linkedListAlgos.NthNodeFromEnd(linkedList.head,2);
        System.out.println("nth Node from end: " + nth.data);

        System.out.println("--------------------------------");

        LinkedList ll1 = new LinkedList();
        ll1.insertAtBegin(1);
        ll1.insertAtEnd(3);
        ll1.insertAtEnd(5);

        LinkedList ll2 = new LinkedList();
        ll2.insertAtBegin(2);
        ll2.insertAtEnd(4);
        ll2.insertAtEnd(6);

        LinkedList sortedList = new LinkedList();
        System.out.println(sortedList);
        sortedList.head = linkedListAlgos.mergeTwoLists(ll1.head,ll2.head);
        System.out.println("Sorted List: " + sortedList);

    }
}

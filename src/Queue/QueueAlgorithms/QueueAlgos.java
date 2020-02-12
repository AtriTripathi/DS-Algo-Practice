package Queue.QueueAlgorithms;

import Queue.QueueImplementations.LinkedQueue;
import Stack.StackImplementations.LinkedStack;

public class QueueAlgos {
    public LinkedQueue reverseQueue(LinkedQueue queue) {
        LinkedStack stack = new LinkedStack();
        while (!queue.isEmpty()) {
            stack.push(queue.deQueue());
        }
        while (!stack.isEmpty()) {
            queue.enQueue(stack.pop());
        }
        return queue;
    }

    // This method checks whether each successive pairs of number in a stack are consecutive or not
    public boolean checkStackPairwiseOrder(LinkedStack stack) {
        LinkedQueue queue = new LinkedQueue();
        boolean pairwiseOrdered = true;
        while (!stack.isEmpty())        // Following two loops are used to reverse the elements in the stack
            queue.enQueue(stack.pop());
        while (!queue.isEmpty())
            stack.push(queue.deQueue());

        while (!stack.isEmpty()) {
            int n = stack.pop();
            queue.enQueue(n);
            if (!stack.isEmpty()) {
                int m = stack.pop();
                queue.enQueue(m);
                if (Math.abs(m - n) != 1)
                    pairwiseOrdered = false;
            }
        }
        while (!queue.isEmpty())        // This loop reverses the elements in the stack to original state
            stack.push(queue.deQueue());
        return pairwiseOrdered;
    }
}

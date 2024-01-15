package lists;

import java.util.Stack;

/**
 * This class contains a group of linked list operations
 *
 * @author Josh Archer
 * @author <your-name>
 * @version 1.0
 */
public class ListOperations
{
    /**
     * Joins together three linked lists into a single linked
     * list. The elements in the first list come first, then
     * the elements in the second, and finally the elements in
     * the third list.
     *
     * @param first the head of the first list
     * @param second the head of the second list
     * @param third the head of the third list
     * @return the head reference of the new list
     */
    public Node join(Node first, Node second, Node third)
    {
        Node current = first;
        while (current.next != null){
            current = current.next;
        }
        current.next = second;
        while(current.next != null){
            current = current.next;
        }
        current.next = third;

        return first;
    }

    /**
     * Merges elements from two linked lists into a new list,
     * where elements are alternating between the two lists.
     *
     * Note: You can assume that the lists are of the same length
     *
     * @param first the head of the first list
     * @param second the head of the second list
     * @return the head reference of the new list
     */
    public Node merge(Node first, Node second)
    {
        Node mergedHead = first;
        while (first != null && second != null) {
            Node firstNext = first.next;
            Node secondNext = second.next;

            first.next = second;
            first = firstNext;

            second.next = first;
            second = secondNext;
        }

        return mergedHead;
    }

    /**
     * Reports whether a linked list is circular or not.
     *
     * @param head the head reference of a linked list
     * @return returns true if the list is circular or false otherwise
     */
    public boolean isCircular(Node head)
    {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }

            if (fast == null || fast.next == null) {
                return false;
            }
        }

        return false;
    }

    /**
     * Returns the element in the central element in a linked list.
     *
     * Note: The central position in a list with an odd number of elements
     * is self-explanatory. For even sized lists, you should pick the
     * lower index at the splitting point.
     *
     * Hint: You will need to first count the number of elements in
     * the list before you can find the middle element. This problem
     * requires multiple traversals of the list
     *
     * @param head the head reference of a linked list
     * @return the element found in the central Node
     */
    public int findMiddle(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    /**
     * Accepts a list of sorted elements in linked list nodes
     * and inserts a new value into the list in sorted order.
     *
     * Note: To make things easier for this method, you can assume
     * that the list is only working with integer elements.
     *
     * @param head the head of a sorted linked list, each element in
     *             the list should store an integer
     * @return returns the head of the linked list after the insert
     * has completed
     */
    public Node insertSorted(Node head, int newValue)
    {
        Node newNode = new Node(newValue);
        if (head == null || newValue < head.data) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;

        while (current.next != null && current.next.data < newValue) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    /**
     * Finds the first occurrence of an element in the linked list,
     * then removes the Node containing that element and moves the
     * Node to the end of the list.
     *
     * Note: You can assume that the search value exists somewhere
     * in the list.
     * Note: This method should only move the first occurrence of
     * the search value when found.
     *
     * @param head the head reference of a linked list
     * @param searchValue the element to search for
     * @return returns the head of the list after the element has
     * moved
     */
    public Node moveToEnd(Node head, int searchValue) {
        Node prev = null;
        Node current = head;
        Node toMove = null;

        while (current != null && current.next != null) {
            if (current.next.data == searchValue) {
                toMove = current.next;
                prev = current;
            }
            current = current.next;
        }

        if (toMove != null && prev != null) {
            prev.next = toMove.next;
            current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = toMove;
            toMove.next = null;
        }

        return head;
    }

    /**
     * Accepts a reference to a linked list of sorted values, then
     * reports whether the elements are in sorted order.
     *
     * Note: To make things easier for this method, you can assume
     * that the list is only working with integer elements.
     *
     * @param head the head reference of the sorted list
     * @return returns true if the list is sorted, or otherwise false
     */
    public boolean isSorted(Node head) {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    /**
     * Removes the first Node from the linked list and moves
     * it to the end of the list. The new head reference of
     * the list is then returned.
     *
     * @param head the head reference of the list
     * @return the new head reference after moving the front
     * Node to the end of the list
     */
    public Node firstToLast(Node head) {
        Node newHead = head.next;
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * Accepts a linked list of sorted elements and removes
     * all duplicate elements from the list.
     *
     * Note: To make things easier for this method, you can assume
     * that the list is only working with integer elements.
     *
     * @param head the head reference of the linked list
     * @return returns the head reference of the list after removing
     * all duplicate elements
     */
    public Node removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // Remove the duplicate node
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * A recursive method that prints out the elements of a
     * link lists in reverse order. Elements at higher indices
     * should be printed before lower indices in the list.
     *
     * @param head the head reference to a linked list
     */
    public void printBackwards(Node head) {
        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data);

            if (stack.isEmpty()) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }
    }

    /**
     * Reports whether two linked lists contain the same elements
     * at the same positions in each list.
     *
     * @param first the reference to the first linked list
     * @param second the reference to the second linked list
     * @return returns true if both lists contain the same elements
     * at the same positions in each list, otherwise it returns false
     *
     * Note: Comparisons between elements should be made using
     * the equals() method.
     */
    public boolean areEqual(Node first, Node second)
    {
        Node currentF = first;
        Node currentS = second;
        while(currentF!=null && currentS!=null){ // Do this until either of these list's elements is null
            if(currentF.data!=currentS.data){
                return false;
            }
            currentF = currentF.next;
            currentS = currentS.next;
        }

        return currentF == null && currentS == null;
    }

    /**
     * Swaps the positions of two elements in a linked list.
     *
     * Hint: You do not need to adjust any Node references in the list.
     * Only the elements in two Nodes need to be swapped.
     *
     * @param head the reference to a linked list
     * @param firstIndex the first index of an element in the list
     * @param secondIndex the second index of an element in the list
     */
    public void swap(Node head, int firstIndex, int secondIndex) {
        // Initialize pointers to keep track of the nodes at the specified positions.
        Node prevFirst = null;
        Node prevSecond = null;
        Node currentFirst = head;
        Node currentSecond = head;
        int currentIndex = 0;

        // Traverse the list to find the nodes at the specified positions.
        while (currentFirst != null && currentIndex < firstIndex) {
            prevFirst = currentFirst;
            currentFirst = currentFirst.next;
            currentIndex++;
        }

        currentIndex = 0; // Reset the index to traverse from the beginning again.

        while (currentSecond != null && currentIndex < secondIndex) {
            prevSecond = currentSecond;
            currentSecond = currentSecond.next;
            currentIndex++;
        }

        // If either of the specified positions is out of bounds, do nothing.
        if (currentFirst == null || currentSecond == null) {
            return;
        }

        // Swap the elements by updating the next pointers.
        if (prevFirst != null) {
            prevFirst.next = currentSecond;
        } else {
            head = currentSecond;
        }

        if (prevSecond != null) {
            prevSecond.next = currentFirst;
        } else {
            head = currentFirst;
        }

        Node temp = currentSecond.next;
        currentSecond.next = currentFirst.next;
        currentFirst.next = temp;

    }


}

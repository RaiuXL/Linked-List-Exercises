package driver;

import lists.ListHelpers;
import lists.ListOperations;
import lists.Node;

/**
 * This class includes informal tests to verify the methods
 * in the ListOperations class.
 *
 * @author ???
 * @version ???
 */
public class ProgramTests
{
    private ListHelpers helpers = new ListHelpers();
    private ListOperations operations = new ListOperations();

    public static void main(String[] args)
    {

    }

    public void problem1()
    {
        System.out.println("\nProblem1() - join");
        System.out.println("Lists before:");
       Node list1 =  helpers.createList(1,3);
       helpers.printList(list1);
       Node list2 = helpers.createList(4,6);
       helpers.printList(list2);
       Node list3 = helpers.createList(7,9);
       helpers.printList(list3);
        System.out.println("List after:");
       Node joinedLists = operations.join(list1,list2,list3);
       helpers.printList(joinedLists);
    }

    public void problem2()
    {
        System.out.println("\nProblem2() - merge");
        System.out.println("Lists before:");
        Node list1 = helpers.createList(1,3);
        helpers.printList(list1);
        Node list2 = helpers.createList(4,6);
        helpers.printList(list2);
        System.out.println("Lists after:");
        Node mergedList = operations.merge(list1,list2);
        helpers.printList(mergedList);
    }

    public void problem3()
    {
        System.out.println("\nProblem3() - isCircular");
        Node list1 = helpers.createCircularList(1,3);
        helpers.printCircularList(list1);
        System.out.println("Circular list? "+operations.isCircular(list1));
        Node list2 = helpers.createList(1,3);
        helpers.printList(list2);
        System.out.println("Circular list? "+operations.isCircular(list2));

    }

    public void problem4()
    {
        System.out.println("\nProblem4() - findMiddle");
        Node list1 = helpers.createList(1,7);
        helpers.printList(list1);
        System.out.println("Middle element - "+operations.findMiddle(list1));
        Node list2 = helpers.createList(1,12);
        helpers.printList(list2);
        System.out.println("Middle element - "+operations.findMiddle(list2));

    }

    public void problem5()
    {
        System.out.println("\nProblem5() - insertedSorted");
        Node list = helpers.createList(1,7);
        helpers.printList(list);
        System.out.println("Inserting 0");
        list = operations.insertSorted(list,0);
        helpers.printList(list);
        System.out.println("Inserting 4");
        list = operations.insertSorted(list,4);
        helpers.printList(list);
        System.out.println("Inserting 8");
        list = operations.insertSorted(list,8);
        helpers.printList(list);
    }

    public void problem6()
    {
        System.out.println("\nProblem6() - moveToEnd");
        Node list = helpers.createList(1,7);
        helpers.printList(list);
        System.out.println("Moving 3");
        list = operations.moveToEnd(list,3);
        helpers.printList(list);
    }

    public void problem7()
    {
        System.out.println("\nProblem7() - isSorted");
        Node list = helpers.createList(1,7);
        helpers.printList(list);
        System.out.println("Sorted? "+operations.isSorted(list));
        Node list2 = helpers.createList(new int[]{1,2,4,3,5,8,7});
        helpers.printList(list2);
        System.out.println("Sorted? "+operations.isSorted(list2));


    }

    public void problem8()
    {
        System.out.println("\nProblem8() - firstToLast");
        Node head = helpers.createList(new int[]{1, 2, 3, 4, 5});

        for (int i = 0; i < 5; i++) {
            helpers.printList(head);
            head = operations.firstToLast(head);
        }

    }

    public void problem9()
    {
        System.out.println("\nProblem9() - removeDuplicates");
        Node head = helpers.createList(new int[]{3, 3, 3, 4, 4, 5});
        helpers.printList(head);
        Node newList = operations.removeDuplicates(head);
        System.out.println("List with duplicates removed:");
        helpers.printList(newList);
    }

    public void problem10()
    {
        System.out.println("\nProblem10() - printBackwards");
        Node head = helpers.createList(new int[]{1, 2, 3});
        helpers.printList(head);
        System.out.println("Printing backwards: ");
        operations.printBackwards(head);

    }

    public void problem11()
    {
        Node head1 = helpers.createList(1,7);
        Node head2 = helpers.createList(1,7);
        helpers.printList(head1);
        helpers.printList(head2);
        System.out.println("Equal? "+operations.areEqual(head1,head2));
        Node head3 = helpers.createList(1,6);
        Node head4 = helpers.createList(1,4);
        helpers.printList(head3);
        helpers.printList(head4);
        System.out.println("Equal? "+operations.areEqual(head3,head4));
    }

    public void problem12()
    {
        Node head=helpers.createList(1,10);
        helpers.printList(head);
        operations.swap(head,2,7);
        System.out.println("Swapping index 2 and 7");
        helpers.printList(head);
    }

}
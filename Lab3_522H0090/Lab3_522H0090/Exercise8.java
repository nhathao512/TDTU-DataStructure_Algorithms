public class Exercise8 <E extends Comparable<E>>
{
    private Node <E> head;

    private static class Node<E>
    {
        E data;
        Node<E> next;

        Node(E item)
        {
            data = item;
            next = null;
        }
    }

    public void addSortedList(E item)
    {
        head = addSortedListRecursive(head, item);
    }

    private Node<E> addSortedListRecursive(Node<E> current, E item) 
    {
        if (current == null || item.compareTo(current.data) < 0) 
        {
            Node<E> newNode = new Node<>(item);
            newNode.next = current;
            return newNode;
        } 
        else 
        {
            current.next = addSortedListRecursive(current.next, item);
            return current;
        }
    }
    
    public int countEvenNumbers() 
    {
        return countEvenNumbersRecursive(head); 
    }

    private int countEvenNumbersRecursive (Node<E> current) 
    {
        if (current == null)
        {
            return 0;
        }
        else if ((Integer) current. data % 2 == 0)
        {
            return 1 + countEvenNumbersRecursive (current.next);
        }
        else 
        {
            return countEvenNumbersRecursive (current.next);
        }
    }

    public int sumAllNumbers()
    {
        return sumAllNumbersRecursive (head);
    }

    private int sumAllNumbersRecursive (Node<E> current) 
    {
        if (current == null) 
        {
            return 0;
        }
        else
        {
            return (Integer) current.data + sumAllNumbersRecursive(current.next);
        }
    }
    public static void main(String[] args) 
    {
        Exercise8 <Integer> list = new Exercise8<>();
        list.addSortedList(5);
        list.addSortedList(2);
        list.addSortedList(8); 
        list.addSortedList(1);
        list.addSortedList(10);
        System.out.println("Sorted Linked List:");
        Node<Integer> current = list.head;
        while (current != null) 
        {
            System.out. print (current.data + " ");
            current = current.next;
        }

        System.out.println("\nNumber of even integers: " + list.countEvenNumbers ());
        System.out.println("Sum of all integers: " + list.sumAllNumbers ());
    }
}
public class IntLinkedList implements ListInterface
{
    private Node head;

    public IntLinkedList()
    {}

    public void addFirst(int data)
    {
        head = new Node(data, head);     
    }

    public boolean addLast(int data)
    {
        Node currNode = head;
        while (currNode.getNext() != null) {
            if (currNode.getData() == data) {
                return false;
            }
            currNode = currNode.getNext();
        }
        currNode.setNext(new Node(data, currNode.getNext()));
        return true;
    }

    public boolean removeAt(int position)
    {
    
        if (position == 1) 
        {
            head = head.getNext();
            return true;
        } 
        else 
        {
            int currPosition = 2;
            Node currNode = head.getNext();
            Node prevNode = head;
            while (currNode.getNext() != null) 
            {
                if (currPosition == position) 
                {
                    prevNode.setNext(currNode.getNext());
                    return true;
                }

                currNode = currNode.getNext();
                prevNode = prevNode.getNext();
                currPosition++;
            }
            return false;
        }
    }

    public int countOdd()
    {
        int count = 0;
        Node currNode = head;
        while (currNode != null) {
            if (currNode.getData() % 2 == 1) {
                count++;
            }
            currNode = currNode.getNext();
        }
        return count;
    }

    public int searchKey(int key)
    {
        int currPosition = 0;
        Node currNode = head;
        while (currNode != null) {
            if (currNode.getData() == key) {
                return currPosition;
            }
            currNode = currNode.getNext();
            currPosition++;
        }
        return -1;
    }

    public boolean checkSorted()
    {
        Node currNode = head;
        if (head.getData() >= currNode.getNext().getData()) {
            while (currNode.getNext() != null) {
                if (currNode.getData() < currNode.getNext().getData()) {
                    return false;
                }
                currNode = currNode.getNext();
            }
            return true;
        } else {
            while (currNode.getNext() != null) {
                if (currNode.getData() > currNode.getNext().getData()) {
                    return false;
                }
                currNode = currNode.getNext();
            }
            return true;
        }
    }

    public void print() 
    {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.getData() + " ");
            currNode = currNode.getNext();
        }
        System.out.println();
    }

    public static void main (String args[]) {
        IntLinkedList list = new IntLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addLast(4);
        list.print();

        System.out.println("Remove At: " + list.removeAt(2));
        list.print();

        System.out.println("Count: " + list.countOdd());

        System.out.println("Search: " + list.searchKey(2));
        System.out.println("Search: " + list.searchKey(5));

        System.out.println("Check Sorted: " + list.checkSorted());

        IntLinkedList list1 = new IntLinkedList();
        list1.addFirst(1);
        list1.addFirst(3);
        list1.addFirst(5);
        list1.addFirst(7);
        System.out.println("Check Sorted: " + list1.checkSorted());
    }
}

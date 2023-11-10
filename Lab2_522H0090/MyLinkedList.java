
import java.util.NoSuchElementException;

public class MyLinkedList <E> implements ListInterface <E> 
{
    private Node <E> head;
    private int numNode;

    public MyLinkedList()
    {
        head = null;
        numNode = 0;
    }

    @Override
    public void addFirst(E item)
    {
        head = new Node<E>(item, head);
        numNode++;
    }

    @Override
    public void addAfter(Node<E> curr, E item)
    {
        if(curr == null)
        {
            addFirst(item);
        }
        else
        {
            Node<E> newNode = new Node<E>(item, curr.getNext());
            curr.setNext(newNode);
            numNode++;
        }
    }

    @Override
    public void addLast(E item)
    {
        if(head == null)
        {
            addFirst(item);
        }
        else
        {
            Node<E> tmp = head;
            while(tmp.getNext() != null)
            {
                tmp = tmp.getNext();
            }
            Node<E> newNode = new Node<E>(item, null);
            tmp.setNext(newNode);
            numNode++;
        }
    }

    @Override
    public E removeFirst() throws NoSuchElementException
    {
        if(head == null)
        {
            throw new NoSuchElementException("Can't remove element from an empty list");
        }
        else
        {
            Node<E> tmp = head;
            head = head.getNext();
            numNode --;
            return tmp.getData();
        }
    }

    @Override
    public E removeAfter(Node<E> curr) throws NoSuchElementException
    { 
        if(curr == null)
        {
            throw new NoSuchElementException("Can't remove element from an empty list");
        }
        else
        {
            Node<E> delNode = curr.getNext();
            if(delNode != null) 
            {
                curr.setNext(delNode.getNext());
                numNode --;
                return delNode.getData();
            }
            else
            {
                throw new NoSuchElementException("No next node to remove");
            }
        }
    }

    @Override
    public E removeLast() throws NoSuchElementException
    {
        if(head == null)
        {
            throw new NoSuchElementException("Can't remove element from an empty list");
        }
        else
        {
            Node<E> preNode = null;
            Node<E> delNode = head;
            if(delNode.getNext() == null)
            {
                return removeFirst();
            }   
            while(delNode.getNext() != null)
            {
                preNode = delNode;
                delNode = delNode.getNext();
            }
            preNode.setNext(delNode.getNext());
            numNode --;
            return delNode.getData();
        }
    }

    @Override
    public void print()
    {
        if(head != null)
        {
            Node<E> tmp = head;
            System.out.print("List: " + tmp.getData());
            tmp = tmp.getNext();
            while(tmp != null)
            {
                System.out.print(" -> " + tmp.getData());
                tmp = tmp.getNext();
            }
            System.out.println();
        }
        else
        {
            System.out.println("List is empty!");
        }   
    }

    @Override
    public boolean isEmpty()
    {
        if(numNode == 0) return true;
            return false;
    }

    @Override
    public E getFirst() throws NoSuchElementException
    {
        if(head == null)
        {
            throw new NoSuchElementException("Can't get element from an empty list");
        }
        else
        {
            return head.getData();
        }
    }

    @Override
    public Node<E> getHead()
    {
        return head;
    }

    @Override
    public int size()
    {
        return numNode;
    }

    @Override
    public boolean contains(E item){
        Node<E> tmp = head;
        while(tmp != null){
            if(tmp.getData().equals(item))
                return true;
            tmp = tmp.getNext();    
        }
       return false;
    }
    
    public E removeCurr(Node<E> curr)
    {
        if (head == null)
        {
            throw new NoSuchElementException("Can't remove element from a empty list");
        }
        else
        {
            if (numNode == 1 || curr == head)
            {
                numNode--;
                return removeFirst();
            }
            else if (curr.getNext() == null)
            {
                numNode--;
                return removeLast();
            }
            else
            {
                Node<E> prevNode = head;
                while (prevNode.getNext() != null)
                {
                    if (prevNode.getNext() == curr)
                    {
                        prevNode.setNext(prevNode.getNext().getNext());
                    }
                    prevNode = prevNode.getNext();
                }
                return curr.getData();
            }
        }
    }

    @Override 
    public int countEven()
    {
        if (head == null)
        {
            throw new NoSuchElementException("Can't count from a empty list");
        }
        else
        {
            int numEven = 0;
            Node<E> temp = head;
            while (temp.getNext() != null)
            {
                if ((int)temp.getData() % 2 == 0)
                {
                    numEven++;
                }
                temp = temp.getNext();
            }
            return numEven;
        }
    }

    private boolean isPrime(int n)
    {
        if (n == 0 && n == 1)
            return false;
        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    @Override
    public int countPrime()
    {
        if (head == null)
        {
            throw new NoSuchElementException("Can't count from a empty list");
        }
        else
        {
            int numPrime = 0;
            Node<E> temp = head;
            while (temp.getNext() != null)
            {
                if (isPrime((int)temp.getData()))
                {
                    numPrime++;
                }
                temp = temp.getNext();
            }
            return numPrime;
        }
    }

    @Override
    public void addBfFEE(E x)
    {
        if (head == null)
        {
            throw new NoSuchElementException("Can't add node before the first even element from a empty list");
        }
        else
        {
            Node<E> curNode = head;
            Node<E> prevNode = null;
            while (curNode != null)
            {   
                if ((int)curNode.getData() % 2 == 0)
                {
                    if (prevNode == null)
                    {
                        addFirst(x);
                    }
                    else
                    {
                        prevNode.setNext(new Node<E> (x,curNode));
                    }
                    numNode++;
                    break;
                }
                prevNode = curNode;
                curNode = curNode.getNext();
            }
        }
    }

    @Override
    public int maximum()
    {
        if(head == null)
        {
            throw new NoSuchElementException("Empty list");
        }
        else
        {
            int max = 0;
            Node<E> temp = head;
            while (temp != null)
            {
                if ((int)temp.getData() > max)
                {
                    max = (int)temp.getData();
                }
                temp = temp.getNext();
            }
            return max;
        }
    } 

    @Override 
    public void reverseList()
    {   
        if (head == null)
        {
            throw new NoSuchElementException("Empty list");
        }
        else
        {
            Node<E> curNode = head;
            Node<E> prevNode = null;
            while (head.getNext() != null)
            {
                head = head.getNext();
                curNode.setNext(prevNode);
                prevNode = curNode;
                curNode = head;
            }
        head.setNext(prevNode);
        }
    }

    @Override 
    public void sortAsc()
    {
        for (int i = 1; i < numNode; i++)
        {
            Node<E> prevNode = head;
            Node<E> curNode = prevNode.getNext();
            while (curNode != null)
            {
                if ((int)prevNode.getData() > (int)curNode.getData())
                {
                    addAfter(curNode, prevNode.getData());
                    removeCurr(prevNode);
                }
                prevNode = curNode;
                curNode = curNode.getNext();
            }
        }
    }
}
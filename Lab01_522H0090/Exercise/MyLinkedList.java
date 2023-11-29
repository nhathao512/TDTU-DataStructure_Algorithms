import java.util.*;

class MyLinkedList<E> implements ListInterface<E> {
    private Node<E> head = null;
    private Node<E> prev = null;
    private int numNodes = 0;

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getPrev() {
        return prev;
    }

    @Override
    public void addFirst(E item) {
        if (head != null) {
            Node<E> n = head;
            head = new Node<E>(item, null, head);
            prev = head;
            n.setPrev(prev);
        } else
            head = new Node<E>(item, null, head);
        numNodes++;
    }

    @Override
    public boolean contains(E item) {
        for (Node<E> n = head; n != null; n = n.getNext()) {
            if (n.getElement().equals(item))
                return true;
        }
        return false;
    }

    @Override
    public E getFirst() {
        if (head == null)
            throw new NoSuchElementException("Can't get from an empty list");
        return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return numNodes == 0;
    }

    @Override
    public void print() {
        if (head == null)
            throw new NoSuchElementException("Nothing to print");
        Node<E> n = head;
        System.out.print("[" + n.getElement());
        for (int i = 1; i < numNodes; i++) {
            n = n.getNext();
            System.out.print("  " + n.getElement());
        }
        System.out.println("]");
    }

    @Override
    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        if (curr != null) {
            Node<E> delNode = curr.getNext();
            if (delNode != null) {
                curr.setNext(delNode.getNext());
                numNodes--;
                return delNode.getElement();
            }
            throw new NoSuchElementException("Can't remove after this node because this is the end of the list");
        } else { // pretend we remove the first node
            return removeFirst();
        }

    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (head != null) {
            Node<E> ln = head;
            head = head.getNext();
            numNodes--;
            return ln.getElement();
        }
        throw new NoSuchElementException("Can't remove from an empty list");
    }

    @Override
    public int size() {
        return numNodes;
    }
}
public class Node<E> {
    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node() {
    }

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public Node(E item) {
        this(item, null, null);
    }

    public E getElement() {
        return element;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
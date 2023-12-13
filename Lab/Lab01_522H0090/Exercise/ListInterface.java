public interface ListInterface<E> 
{
    public boolean isEmpty();

    public void addFirst(E item);

    public E getFirst();

    public E removeFirst();

    public boolean contains(E item);

    public int size();

    public void print();

    public E removeAfter(Node<E> curr);
}
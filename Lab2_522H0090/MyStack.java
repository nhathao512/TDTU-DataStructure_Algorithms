import java.util.NoSuchElementException;

public class MyStack <E> extends MyLinkedList <E> implements StackInterface <E>
{ 

    @Override
    public void push(E item)
    {
        addFirst(item);
    }
    @Override
    public E pop() throws NoSuchElementException
    {
        return removeFirst();
    } 
    @Override
    public E getPeek() throws NoSuchElementException
    {
        return getFirst();
    }
}
    
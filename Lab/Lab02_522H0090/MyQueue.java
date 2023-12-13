import java.util.NoSuchElementException;

public class MyQueue<E> extends MyLinkedList<E> implements QueueInterface<E> 
{
    public void enQueue(E item)
    {
        addLast(item);
    }    
    public E deQueue() throws NoSuchElementException
    {
        return removeFirst();
    }
    @Override
    public E getFront() throws NoSuchElementException 
    {
        return getFirst();
    }
}

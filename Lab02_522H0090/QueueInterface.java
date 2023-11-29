import java.util.NoSuchElementException;

public interface QueueInterface <E>
{
    public void enQueue(E item);
    public E deQueue() throws NoSuchElementException;
    public E getFront() throws NoSuchElementException;
}

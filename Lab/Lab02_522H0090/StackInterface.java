import java.util.NoSuchElementException;
public interface StackInterface<E>
{
    public void push(E item);
    public E pop() throws NoSuchElementException;
    public E getPeek() throws NoSuchElementException;
}
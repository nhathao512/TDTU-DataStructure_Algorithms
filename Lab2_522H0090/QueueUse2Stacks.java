import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUse2Stacks <E> 
{
    private Stack<E> stack1;
    private Stack<E> stack2;
    
    public QueueUse2Stacks()
    {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public QueueUse2Stacks(Stack<E> stack1, Stack<E> stack2)
    {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }

    public void enQueue(E item)
    {
        stack1.push(item);
    }

    public E deQueue() throws NoSuchElementException
    {
        if (!stack1.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public E getFront() throws NoSuchElementException
    {
        return stack2.peek();
    }
    
    public void print()
    {
        System.out.print("Queue using 2 stacks: ");
        if (!stack1.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
        }
        while (!stack2.isEmpty())
        {
            System.out.print(stack2.pop() + " ");
        }
    }
}
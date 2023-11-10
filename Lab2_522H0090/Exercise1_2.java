public class Exercise1_2 
{
    public static void main(String[] args)
    {
        MyStack<Fraction> stacks = new MyStack<>();
        MyQueue<Fraction> queues = new MyQueue<>();
        for (int i = 0; i < 6; i++)
        {
            stacks.push(new Fraction(i*2+1, i+1));
            queues.enQueue(new Fraction(i, i+1));
        }
        stacks.pop();
        stacks.print();
        queues.deQueue();
        queues.print();
    }
}
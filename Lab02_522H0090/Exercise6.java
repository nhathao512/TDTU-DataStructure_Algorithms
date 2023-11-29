public class Exercise6 {
    public static void main(String[] args) 
    {
        QueueUse2Stacks<Integer> queue2stack = new QueueUse2Stacks<>();
        queue2stack.enQueue(1);
        queue2stack.enQueue(2);
        queue2stack.enQueue(3);
        queue2stack.enQueue(4);
        queue2stack.enQueue(5);
        queue2stack.deQueue();
        queue2stack.print();
    }
}

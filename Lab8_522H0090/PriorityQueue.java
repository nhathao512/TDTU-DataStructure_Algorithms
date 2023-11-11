import java.util.NoSuchElementException;

public class PriorityQueue 
{
    Person[] heap;
    int heapSize;
    int maxSize; 

    public PriorityQueue(int capity)
    {
        heapSize = 0;
        this.maxSize = capity + 1;
        heap = new Person[maxSize];
        heap[0] = null;
    }

    private int parent(int i)
    {
        return i / 2;
    }

    private int left(int i)
    {
        return i * 2;
    }

    private int right(int i)
    {
        return i * 2 + 1;
    }

    private void swap(int i,int j)
    {
        Person temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void shiftUp(int i)
    {
        while (i > 1 && heap[parent(i)].compareTo(heap[i]) < 0)
        {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public void insert(Person key)
    {
        if (heapSize == maxSize)
        {
            throw new NoSuchElementException("Overflow Exception");        
        }
        heapSize += 1;
        heap[heapSize] = key;

        shiftUp(heapSize);
    }

    public Person extractMax()
    {
        if (heapSize == 0)
        {
            throw new NoSuchElementException("Underflow Exception");
        }
        Person max = heap[1];
        heap[1] = heap[heapSize];
        heapSize -= 1;
        shiftDown(1);
        return max;
    }

    private void shiftDown(int i)
    {
        while (i <= heapSize)
        {
            Person max = heap[i];
            int max_id = i;
            if (left(i) <= heapSize && max.compareTo(heap[left(i)]) < 0)
            {
                max = heap[left(i)];
                max_id = left(i);
            }
            if (right(i) <= heapSize &&  max.compareTo(heap[right(i)]) < 0)
            {
                max = heap[right(i)];
                max_id = right(i);
            }
            if (max_id != i)
            {
                swap(max_id, i);
                i = max_id;
            }
            else
            {
                break;
            }
        }
    }

    public static void heapSort(int[] arr)
    {
        Maxheap heap = new Maxheap(arr.length + 1);
        for (int i : arr)
        {
            heap.insert(i);
        }
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = heap.extractMax();
        }
    }

    public static void main(String[] args)
    {
        PriorityQueue queue = new PriorityQueue(20);

        queue.insert(new Person("Alex",3));
        queue.insert(new Person("Bob",2));
        queue.insert(new Person("David",6));
        queue.insert(new Person("Susan",1));

        Person p1 = queue.extractMax();
        System.out.println("Dequeue: " + p1);

        queue.insert(new Person("Mike",5));
        queue.insert(new Person("Kevin",4));

        p1 = queue.extractMax();
        System.out.println("Dequeue: " + p1);

        p1 = queue.extractMax();
        System.out.println("Dequeue: " + p1);

        queue.insert(new Person("Helen", 0));
        queue.insert(new Person("Paul", 8));
        queue.insert(new Person("Iris", 7));

        p1 = queue.extractMax();
        System.out.println("Dequeue: " + p1);
    }
}

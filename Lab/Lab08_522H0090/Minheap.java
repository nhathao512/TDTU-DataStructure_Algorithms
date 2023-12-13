import java.util.NoSuchElementException;

public class Minheap 
{
    int[] heap;
    int heapSize;
    int minSize;

    public Minheap(int capity)
    {
        heapSize = 0;
        this.minSize = capity + 1;
        heap = new int [minSize];
        heap[0] = -1;
    }

    private int parent(int i)
    {
        return i / 2;
    }

    private int left(int i)
    {
        return 2 * i;
    }

    private int right(int i)
    {
        return 2 * i + 1;
    }

    private void swap(int i,int j)
    {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void shiftUp(int i)
    {
        while (i > 1 && heap[parent(i)] > heap[i])
        {
            swap(parent(i), i);
            i = parent(i);
        }
    }

    public void insert(int key)
    {
        if (heapSize == minSize)
        {
            throw new NoSuchElementException("Overflow Exception");        
        }
        heapSize += 1;
        heap[heapSize] = key;

        shiftUp(heapSize);
    }

    public int extractMin()
    {
        if (heapSize == 0)
        {
            throw new NoSuchElementException("Underflow Exception");
        }
        int min = heap[1];
        heap[1] = heap[heapSize];
        heapSize -= 1;
        shiftDown(1);
        return min;
    }

    private void shiftDown(int i)
    {
        while (i <= heapSize)
        {
            int min = heap[i];
            int min_id = i;
            if (left(i) <= heapSize && min > heap[left(i)])
            {
                min = heap[left(i)];
                min_id = left(i);
            }
            if (right(i) <= heapSize && min > heap[right(i)])
            {
                min = heap[right(i)];
                min_id = right(i);
            }
            if (min_id != i)
            {
                swap(min_id, i);
                i = min_id;
            }
            else
            {
                break;
            }
        }
    }

    public static void heapSort(int[] arr)
    {
        Minheap heap = new Minheap(arr.length + 1);
        for (int i : arr)
        {
            heap.insert(i);
        }
        for (int i = 0; i < arr.length; i++)    // sort decreasingly
        {
            arr[i] = heap.extractMin();
        }
        // for (int i = arr.length - 1; i >= 0; i--)   //sort increasingly
        // {
        //     arr[i] = heap.extractMin();
        // }
    }
    public static void main(String[] args)
    {
        int[] arr = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};
        heapSort(arr);
        for (int a : arr)
        {
            System.out.print(a + " ");
        }
    }
}

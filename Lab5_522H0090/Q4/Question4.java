package Q4;

public class Question4 
{
    public static void SelectionSort(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n -1; i++)
        {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
            {
                if (a[j] < a[min_idx])
                {
                    min_idx = j;
                }
            }
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }
    
    public static void BubbleSort(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (a[j] > a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void InsertionSort(int[] a)
    {
        int n = a.length;
        for (int i = 1; i < n - 1; i++)
        {
            int key = a[i];
            int j = i - 1;
            while(j >= 0 && a[j] > key)
            {
                a[j+1] = a[j];
                j = j - 1;
            }
            a[j+1] = key;
        }
    }

    public static void printArray(int[] a) 
    {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

    public static void main(String[] args) 
    {
		int[] arr = { 7, 12, 3, 5, -6, 3, 8, 2, 10, -3 };
        printArray(arr);
		SelectionSort(arr);
		printArray(arr);

        // printArray(arr);
		// BubbleSort(arr);
		// printArray(arr);

        // printArray(arr);
		// InsertionSort(arr);
		// printArray(arr);

    }
}

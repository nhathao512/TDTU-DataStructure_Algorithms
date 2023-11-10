public class SelectionSort
{
    public static void selectionSort(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
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
    
    public static void main(String[] args)
    {
        int[] a = {6, 3, 5, 7, 6, 2};
        selectionSort(a);
        
        for(int num : a)
        {
            System.out.print(num + " ");
        }
        
    }
}
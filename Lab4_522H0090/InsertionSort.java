public class InsertionSort 
{
    public static void insertionSort(int[] a)
    {
        int n = a.length;
        for (int i = 1; i < n; i++)
        {
            int key = a[i];
            int j = i-1;

            while(j >= 0 && a[j] > key)
            {
                a[j+1] = a[j];
                j = j-1;
                a[j+1] = key;
            }
        }
    }
    
    public static void main(String[] args)
    {
        int[] a = {6, 3, 5, 7, 6, 2};
        insertionSort(a);
        for(int num : a)
        {
            System.out.print(num + " ");
        }
        
    }
}

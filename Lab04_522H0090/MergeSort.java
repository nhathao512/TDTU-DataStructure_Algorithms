public class MergeSort 
{
    private static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void mergeSort(int[] arr, int first, int last)
    {
        if (first < last)
        {
            int middle = (first + last)/2;
            mergeSort(arr, first, middle);
            mergeSort(arr, middle + 1, last);
            merge(arr, first, middle, last);
        }
    }

    public static void printArray(int[] arr)
    {
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int[] arr = {4, 1, 5, 7, 6, 2};
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}

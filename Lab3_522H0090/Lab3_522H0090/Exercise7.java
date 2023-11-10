public class Exercise7
{
    public static int findmin(int[] arr, int size)
    {
        if (size == 1)
        {
            return arr[0];
        }
        int subMin = findmin(arr, size - 1);
        return Math.min(subMin, arr[size - 1]);
    }

    public static int sumElement(int[] arr, int size)
    {
        if (size == 0)
        {
            return 0;
        }
        return sumElement(arr, size - 1) + arr[size - 1];
        
    }

    public static int countElement(int[] arr, int size)
    {
        if (size == 0)
        {
            return 0;
        }
        int lastElement = arr[size - 1];
        int count = countElement(arr, size - 1);

        if (lastElement % 2 == 0) 
        {
            count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = {9, 2, 8, 4, 5};
        int size = arr.length;
        int mini = findmin(arr, size);
        int sum = sumElement(arr, size);
        int cou = countElement(arr, size);
        System.out.println(mini);
        System.out.println(sum);
        System.out.println(cou);
    }
}
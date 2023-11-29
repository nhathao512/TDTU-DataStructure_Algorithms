public class Exercise6 
{
    public static int Minimum(int[] arr)
    {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
            }
        }
        return min;
    }

    public static int sumElement(int[] arr)
    {
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int countElement(int[] arr)
    {
        int count = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0)
            {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] arr = {9, 2, 8, 4, 5};
        int min = Minimum(arr);
        int sum = sumElement(arr);
        int count = countElement(arr);
        System.out.println(min);
        System.out.println(sum);
        System.out.println(count);
    }
}

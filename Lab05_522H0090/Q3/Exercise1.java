public class Exercise1 
{
    public static double prod_recur(int a, int b)
    {
        if(a < b)
        {
            return prod_recur(b, a);
        }   
        else if(b != 0)
            return (a + prod_recur(a, b-1)); //b time of a
        else
            return 0;
    }
    public static int bin2dec(int n, int exp)
    {
        if (n == 0)
        {
            return 0;
        }
        int lastDigit = n % 10;
        int decimal = lastDigit * (int)Math.pow(2, exp);
        return decimal + bin2dec(n / 10, exp + 1);
    }

    // public static int dec2bin(int n)
    // {
    //     if (n == 0)
    //     {
    //         return 0;
    //     }
    //     else
    //     {
    //         return n % 2 + 10 * dec2bin(n / 2);
    //     }
    // }

    public static int maxDigit(int n)
    {
        n = Math.abs(n);
        if (n < 0)
        {
            return 0;
        }
        int digit = n % 10;
        return Math.max(digit, maxDigit(n / 10));
    }
    
    public static int maxElement(int[] a, int n)
    {
        if (n == 1)
        {
            return a[0];
        }
        else
        {
            return Math.max(a[n-1], maxElement(a, n-1));
        }
    }

    public static int search(int[] a, int n, int key)
    {
        if (n == 1)
        {
            if (a[0] == key)
                return 1;
        }
        
        return 0;
    }
    public static void main(String[] args)
    {
        int n[] = {1, 9, 3, 7, 5};
        int a = 1000;
        int b = 0;
        System.out.println(prod_recur(a, b));
        System.out.println(bin2dec(a, b));
        //System.out.println(dec2bin(8));
        System.out.println(maxDigit(a));
        System.out.println(maxElement(n, n.length));
    }
}

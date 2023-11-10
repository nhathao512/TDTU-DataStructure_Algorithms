public class Exercise1
{
    public static double Factorial(int n)
    {
        double factorial = 1;
        for (int i = 2; i <= n; i++)
        {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static double PowX(int x, int n)
    {
        int pow = 1;
        for (int i = 1; i <= n ; i++)
        {
            pow = pow * x;
        }
        return pow;
    }

    public static int Count(int n)
    {
        int count = 0;
        while(n > 0)
        {
            n /= 10;
            count++;
        }
        return count;
    }

    public static boolean Prime(int n)
    {
        if (n <= 1)
        {
            return false;
        }
        else
        {
            for (int i = 2; i <= Math.sqrt(n); i++)
            {
                if (n % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }

    public static int GCD(int a, int b)
    {
        while(b != 0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] ards)
    {
        int num = 17;
        int n1 = 2;
        int n2 = 3;
        
        System.out.println(Factorial(num));
        System.out.println(PowX(n1, n2));
        System.out.println(Count(num));
        System.out.println(Prime(num));
        System.out.println(GCD(n1, n2));
    }
}
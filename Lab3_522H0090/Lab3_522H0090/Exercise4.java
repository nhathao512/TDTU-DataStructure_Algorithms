public class Exercise4 
{
    public static double P(int n)
    {
        if(n == 1)
        {
            return 3;
        }
        else
        {
            return 2 * n + 1 + P(n - 1);
        }
    }
    public static int Factorial(int n)
    {
        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            return n * Factorial(n - 1);
        }
    }

    public static int sumFactorial(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return Factorial(n) + sumFactorial(n - 1);
        }
    }

    public static int mulFactorial(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return Factorial(n) * mulFactorial(n - 1);
        }
    }

    public static double P_d(int n, int r)
    {
        if (r == 0)
        {
            return 1;
        }

        if (n >= r && r > 0)
        {
            return n * P_d(n - 1, r -1);
        }
        else
        {
            return 1;
        }

    }
    public static double P_e(int n)
    {
        if (n == 1)
        {
            return 3;
        }
        else
        {
            return Math.pow(2, n) + Math.pow(n, 2) + P_e(n - 1);
        }
    }
    
    public static void main(String[] args)
    {
        int n1 = 4;
        int n2 = 3;
        System.out.println(P(n1));
        System.out.println(sumFactorial(n1));
        System.out.println(mulFactorial(n1));
        System.out.println(P_d(n1, n2));
        System.out.println(P_e(n1));
    }
}

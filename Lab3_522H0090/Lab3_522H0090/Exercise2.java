public class Exercise2 
{
    public static double Factorial(int n)
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

    public static double PowX(int x, int n)
    {
        if (n == 0)
        {
            return 1;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double halfPower = PowX(x, n / 2);
        
        if (n % 2 == 0) 
        {    
            return halfPower * halfPower;
        } 
        else 
        {
            return x * halfPower * halfPower;
        }

    }
    public static int Count(int n)
    {
        if (n == 0)
        {
            return 0;
        }
        else
        {
            return 1 + Count(n / 10);
        }
    }

    public static int GCD(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        else
        {
            return GCD(b, a % b);
        }
    }

    public static void main(String[] args)
    {
        int n1 = 2;
        int n2 = 3;

        System.out.println(Factorial(n1));
        System.out.println(PowX(n1, n2));
        System.out.println(Count(n1));
        System.out.println(GCD(n1, n2));
    }
}

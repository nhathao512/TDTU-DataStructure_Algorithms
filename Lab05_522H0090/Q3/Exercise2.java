import java.lang.Math;
public class Exercise2 
{
    public static double iteration_A(int n)
    {
        double num = 0;
        for (int i = 1; i <= n; i++)
        {
            num = num + Math.pow(2, i);
        }
        return num;
    }

    public static double recursion_A(int n)
    {
        if (n == 1)
        {
            return 2;
        }
        else
        {
            return Math.pow(2, n) + recursion_A(n-1);
        }
    }

    public static double iteration_B(int n)
    {
        double num = 0;
        for (int i = 0; i <= n; i++)
        {
            num = num + (i + 1) / 2.0;
        }
        return num;
    }

    public static double recursion_B(int n)
    {
        if (n == 0)
        {
            return 1 / 2.0;
        }
        else
        {
            return recursion_B(n-1) + (n + 1) / 2.0;
        }
    }

    public static double iteration_Fac(int n)
    {
        double factorial = 1;
        for (int i = 2; i <= n; i++)
        {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static double iteration_C(int n)
    {
        double num = 0;
        for (int i = 1; i <= n; i++)
        {
            num = num + iteration_Fac(i) / iteration_Fac(i - 1);
        }
        return num;
    }

    public static double recuration_Fac(int n)
    {
        if (n == 0) {
            return 1;
        }
        return n * recuration_Fac(n - 1);
    }

    public static double recursion_C(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return recuration_Fac(n) / recuration_Fac(n - 1) + recursion_C(n - 1);
        }
    }

    public static double iteration_D(int n)
    {
        int num = 0;
        for (int i = 1; i <= n; i++)
        {
            num = num + (i * (i - 1));
        }
        return num;
    }

    public static double recursion_D(int n)
    {
        if (n == 1)
        {
            return 0;
        }
        else
        {
            return n * (n - 1) + recursion_D(n - 1);
        }
    }

    public static double iteration_E(int n)
    {
        int num = 1;
        for (int i = 1; i <= n; i++)
        {
            num = num * i;
        }
        return num;
    }

    public static double recursion_E(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else 
        {
            return n * recursion_E(n - 1);
        }
    }

    public static void main(String[] args)
    {
        int n = 5;
        System.out.println("Iteration: " + iteration_A(n));
        System.out.println("Recursion: " + recursion_A(n));
        System.out.println("Iteration: " + iteration_B(n));
        System.out.println("Recursion: " + recursion_B(n));
        System.out.println("Iteration: " + iteration_C(n));
        System.out.println("Recursion: " + recursion_C(n));
        System.out.println("Iteration: " + iteration_D(n));
        System.out.println("Recursion: " + recursion_D(n));
        System.out.println("Iteration: " + iteration_E(n));
        System.out.println("Recursion: " + recursion_E(n));
    }
}

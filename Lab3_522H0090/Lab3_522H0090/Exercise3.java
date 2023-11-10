public class Exercise3 
{
    public static boolean checkPrime(int n, int d)
    {
        if (n <= 1)
        {
            return false;
        }
        if (d * d > n)
        {
            return true;
        }
        if (n % d == 0)
        {
            return false;
        }
        return checkPrime(n, d + 1);
    }

    public static void main(String[] args)
    {
        int a = 6;
        int b = 2;
        System.out.println(checkPrime(a, b));
    }
}

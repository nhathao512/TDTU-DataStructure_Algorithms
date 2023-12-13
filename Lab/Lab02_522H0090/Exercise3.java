import java.util.*;

public class Exercise3 
{
    public static int P(int n)
    {
        if (n == 1)
            return 3;
        else
        {
            return (int) Math.pow(2, n) + n * n + P(n - 1);
        } 
    }

    public static int nP(int n)
    {
        Stack<Integer> stacks = new Stack<>();
        stacks.push(3);
        int result = 0;
        for (int i = 2; i <= n; i++)
        {
            result = (int)Math.pow(2, i) + i * i + stacks.pop();
            stacks.push(result);
        }
        return result;
    }

    public static void main(String[] args )
    {
        System.out.print("enter n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println("P(n) by recursive = " + P(n));
        System.out.println("P(n) by stack = " + nP(n));
    }
}

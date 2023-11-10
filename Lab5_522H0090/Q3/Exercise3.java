public class Exercise3 {
    public static double recursionA(int n) {
        return (n == 0) ? 2 : 2 - recursionA(n - 1) / 2.0;
    }

    public static double iterationA(int n) {
        double res = 2;
        for (int i = 1; i <= n - 1; i++) {
            res -= (i - 1) / 2.0;
        }
        return res;
    }

    public static int recursionB(int n) {
        return (n < 10) ? 1 : 1 + recursionB(n / 10);
    }

    public static int iterationB(int n) {
        int res = 1;
        while (n >= 10) {
            res++;
            n /= 10;
        }
        return res;
    }

    private static int recursionC(int n, int k) {
        if (k == 1)
            return n;
        return n + recursionC(n, k - 1);
    }

    public static int recursionC(int n) {
        return recursionC(n, n);
    }

    private static int iterationC(int n, int k) {
        int res = 0;
        while (k != 0) {
            res += n;
            k--;
        }
        return res;
    }

    public static int iterationC(int n) {
        return iterationC(n, n);
    }

    public static int recursionD(int n) {
        return (n == 0) ? 0 : (n == 1) ? 1 : recursionD(n - 1) + recursionD(n - 2);
    }

    public static int iterationD(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int res = 0;
        int fibo1 = 0;
        int fibo2 = 1;

        for (int i = 2; i <= n; i++) {
            res = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(recursionA(2));
        System.out.println(iterationA(2));

        System.out.println(recursionB(12545));
        System.out.println(iterationB(45125));

        System.out.println(recursionC(2));
        System.out.println(iterationC(2));

        System.out.println(recursionD(4));
        System.out.println(iterationD(4));
    }
}

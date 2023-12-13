package Q2;
import java.util.*;
public class Exercise2 
{
    public static boolean isPalindrome(int n) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        while (n > 0) {
            int item = n % 10;
            stack.push(item);
            queue.add(item);
            n /= 10;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(102));
    }
}


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Exercise7 
{
    public static void main(String[] args) 
    {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println("Check Palindrome: " + isPalindrome(s)); 
    }
    public static boolean isPalindrome(String s)
    {
        Stack<Character> stacks = new Stack<>();
        Queue<Character> queues = new LinkedList<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                queues.add(Character.toLowerCase(c));
                stacks.push(Character.toLowerCase(c));
            }
        }
        while (!stacks.isEmpty() && !queues.isEmpty())
        {
            if (stacks.pop() != queues.remove())
            {
                return false;
            }
        }
        return true;
    }

}

import java.util.Scanner;
import java.util.Stack;

public class Exercise4 
{
    public static void main(String[] args) 
    {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println("Reversed string: " + reverseByStack(s));
    }
    
    public static String reverseByStack(String s)
    {
        Stack<Character> stacks = new Stack<>();
        String newS = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            stacks.push(c);
        }
        while (!stacks.isEmpty())
        {
            newS += stacks.pop();
        }
        return newS;
    }
}

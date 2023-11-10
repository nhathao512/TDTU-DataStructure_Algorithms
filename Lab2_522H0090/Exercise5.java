import java.util.Scanner;
import java.util.Stack;

public class Exercise5 
{
    public static void main(String[] args) 
    {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println("Check balence : " + isBalenced(s));    
    }
    public static boolean isBalenced(String s)
    {
        Stack<Character> stacks = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
            {
                stacks.push(c);
            }
            else
            {
                if (!isMatched(stacks.pop(), c))
                    return false;
            }
        }
        return true;
    }
    
    private static boolean isMatched(char right, char left) 
    {
        if (right == '{' && left == '}')
            return true;
        else if (right == '[' && left == ']')
            return true;
        else if (right == '(' && left == ')')
            return true;
        return false;
    }
}

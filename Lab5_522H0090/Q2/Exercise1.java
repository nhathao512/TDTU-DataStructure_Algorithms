package Q2;
import java.util.Stack;

public class Exercise1 
{
    public static int calculate(String[] expression) 
    {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < expression.length; i++) 
        {
            if (isNumber(expression[i])) 
            {
                int tmp = Integer.parseInt(expression[i]);
                stack.push(tmp);
            }
            else 
            {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (expression[i].compareTo("+") == 0) 
                {
                    stack.push(num1 + num2);
                }
                else if (expression[i].compareTo("-") == 0)
                {
                    stack.push(num2 - num1);
                }
                else if (expression[i].compareTo("*") == 0)
                {
                    stack.push(num2 * num1);
                }
                else
                {
                    if (num1 != 0) 
                    {
                        stack.push(num2 / num1);
                    } 
                    else 
                    {
                        System.out.println("Error: Division by zero"); 
                    }
                }
            }
        }
        return stack.pop();
    }
    private static boolean isNumber(String str) 
    {
        return str.matches("0|([1-9][0-9]*)");
    }
    public static void main(String args[])
    {
        System.out.println(calculate(new String[]{"9", "2", "-", "6", "*", "7", "+","7", "/"}));
	}
}
package Q2;
import java.util.Stack;
public class Exercise3 
{
    public static String reverseSentence(String str) {
        Stack<String> stack = new Stack<>();
        String[] strArr = str.split(" ");

        for (String part : strArr) {
            stack.push(part);
        }

        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop() + " ";
        }
        return res.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("I like apple"));
    }
}

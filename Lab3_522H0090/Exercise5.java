public class Exercise5 
{
    public static int DecimaltoBinary(int dec)
    {
        if (dec == 0)
        {
            return 0;
        }
        else
        {
            return (dec % 2) + 10 * DecimaltoBinary(dec / 2);
        }
    }

    public static void main(String[] args)
    {
        int dec = 8;
        int bin = DecimaltoBinary(dec);
        System.out.println("Decimal number to Binary: " + bin);
    }
}

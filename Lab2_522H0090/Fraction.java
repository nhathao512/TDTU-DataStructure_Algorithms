public class Fraction
{
    private int numer = 0;
    private int denom = 1; 
    
    public Fraction() {}

    public Fraction(int x, int y)
    {
        this.numer = x;
        this.denom = y;
    }

    public Fraction(Fraction f)
    {
        this.numer = f.numer;
        this.denom = f.denom;
    }

    public Fraction reduce()
    {
        Fraction new_f = new Fraction();
        for (int i = this.numer; i > 0; i--)
        {
            if (this.numer % i == 0)
            {
                for (int j = i; j > 0; j--)
                {
                    if (this.denom % j == 0 && j == i)
                    {
                        new_f.numer = this.numer / i;
                        new_f.denom = this.denom / j;
                        return new_f;
                    }
                }

            }
        }
        return new_f;
    }

    public String toString()
    {
        return "["+this.numer+"/"+this.denom+"]";
    }

    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj instanceof Fraction) 
        {
            Fraction otherFraction = (Fraction) obj;
            Fraction thisReduced = this.reduce();
            Fraction otherReduced = otherFraction.reduce();
            
            return thisReduced.numer == otherReduced.numer && thisReduced.denom == otherReduced.denom;
        }
        return false;
    }
    
}


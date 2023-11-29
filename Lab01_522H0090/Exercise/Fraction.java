public class Fraction {
    private int numer = 0;
    private int denom = 1;

    public Fraction() {
    }

    public Fraction(int numer, int denom) {
        this.numer = numer;
        this.denom = denom;
    }

    public Fraction(Fraction f) {
        this(f.numer, f.denom);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numer, denom);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction temp = (Fraction) obj;
            return this.numer * temp.denom - this.denom * temp.numer == 0;
        }
        return false;
    }

}
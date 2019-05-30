package itmo.java;

public class Fraction {
    int m, n;

    Fraction() {
        m = 0;
        n = 1;
    }

    Fraction(int m, int n) throws IllegalArgumentException {
        if (n == 0) {
            throw new IllegalArgumentException("n cannot be equal to zero");
        }
        this.m = m;
        this.n = n;
        reduce();
    }

    Fraction(int m) {
        this.m = m;
        this.n = 1;
        reduce();
    }

    Fraction(Fraction f) {
        this.m = f.m;
        this.n = f.n;
        reduce();
    }

    public boolean equals(Fraction f) {
        return (n == f.n && m == f.m);
    }

    public int compareTo(Fraction f) {
        return (equals(f)) ? 0 : (m * f.n - f.m * n > 0) ? 1 : -1;
    }

    private void reduce() {
        int gcd = Arithmetics.gcd(this.m, this.n);
        this.m /= gcd;
        this.n /= gcd;
        if (this.n < 0) { this.n *= -1; this.m *= -1; }
    }

    public Fraction plus(Fraction fraction) {
        int resultM = this.m * fraction.n + fraction.m * this.n;
        int resultN = this.n * fraction.n;
        Fraction result = new Fraction(resultM, resultN);
        return result;
    }

    public String toString() {
        return m + "/" + n;
    }
}

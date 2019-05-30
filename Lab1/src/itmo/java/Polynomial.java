package itmo.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Polynomial {
    private ArrayList<Fraction> coefficients;

    Polynomial() {
        coefficients = new ArrayList<Fraction>();
    }

    Polynomial(FractionList fractionList) {
        coefficients = fractionList.getFractionList();
    }

    Polynomial plus(Polynomial polynomial) {
        Fraction[] coefFirst = coefficients.toArray(Fraction[]::new);
        Fraction[] coefSecond = polynomial.getCoefficients().toArray(Fraction[]::new);
        Fraction[] coefResult;
        int length1 = coefFirst.length, length2 = coefSecond.length;
        if (length1 > length2) {
            coefResult = new Fraction[length1];
            int i;
            for (i = 0; i < length2; i++) {
                coefResult[i] = coefFirst[i].plus(coefSecond[i]);
            }
            for (; i < length1; i++) {
                coefResult[i] = coefFirst[i];
            }
        }
        else {
            coefResult = new Fraction[length2];
            int i;
            for (i = 0; i < length1; i++) {
                coefResult[i] = coefFirst[i].plus(coefSecond[i]);
            }
            for (; i < length2; i++) {
                coefResult[i] = coefSecond[i];
            }
        }
        ArrayList<Fraction> fractions = new ArrayList<>(Arrays.asList(coefResult));
        FractionList fractionList = new FractionList(fractions);
        Polynomial result = new Polynomial(fractionList);
        return result;
    }

    protected ArrayList<Fraction> getCoefficients() {
        return coefficients;
    }

    public String toString() {
        String result = "";
        int i = 0;
        for (Fraction fraction : coefficients) {
            result += "x^" + i + "*(" + fraction.toString() + ") + ";
            i++;
        }
        return result.substring(0, result.length() - 3);
    }
}

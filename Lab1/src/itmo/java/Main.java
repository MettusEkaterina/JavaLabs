package itmo.java;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        FractionList fractionList1 = new FractionList();
        File file1 = new File("1.txt");
        fractionList1.fill(file1);
        Polynomial polynomial1 = new Polynomial(fractionList1);
        System.out.println(polynomial1);

        FractionList fractionList2 = new FractionList();
        File file2 = new File("2.txt");
        fractionList2.fill(file2);
        Polynomial polynomial2 = new Polynomial(fractionList2);
        System.out.println(polynomial2);

        Polynomial polynomial3 = polynomial1.plus(polynomial2);
        System.out.println(polynomial3);
    }
}

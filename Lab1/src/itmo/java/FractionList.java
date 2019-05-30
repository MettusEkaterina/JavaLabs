package itmo.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FractionList {
    ArrayList<Fraction> fractionList;
    Fraction minimum, maximum;
    int[] countMore, countLess;
    int currentFreePlaceMore = 0, currentFreePlaceLess = 0;
    Fraction[] selectedForLessFraction, selectedForMoreFraction;

    FractionList()
    {
        fractionList = new ArrayList<Fraction>();
        minimum = new Fraction();
        maximum = new Fraction();
        countMore = new int[3];
        countLess = new int[3];
        selectedForLessFraction = new Fraction[3];
        selectedForMoreFraction = new Fraction[3];
    }

    FractionList(ArrayList<Fraction> fractions) {
        this();
        fractionList = fractions;
    }

    void fill(File file) {
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                int _m = sc.nextInt();
                int _n = sc.nextInt();
                Fraction fraction = new Fraction(_m, _n);
                this.add(fraction);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        finally {
            sc.close();
        }
    }

    Fraction getMinimum() {
        return minimum;
    }

    Fraction getMaximum() {
        return maximum;
    }

    void add(Fraction number) {
        fractionList.add(number);
        if (number.compareTo(minimum) == -1) {
            minimum = number;
        } else if (number.compareTo(maximum) == 1) {
            maximum = number;
        }
    }

    void calcCountMoreThan(Fraction f) {
        countMore[currentFreePlaceMore] = 0;
        for (Fraction fraction : fractionList) {
            if (fraction.compareTo(f) == 1) {
                countMore[currentFreePlaceMore]++;
            }
        }
        if (currentFreePlaceMore == countMore.length - 1) {
            currentFreePlaceMore = 0;
        } else {
            currentFreePlaceMore++;
        }
    }

    void calcCountLessThan(Fraction f) {
        countLess[currentFreePlaceLess] = 0;
        for (Fraction fraction : fractionList) {
            if (fraction.compareTo(f) == -1) {
                countMore[currentFreePlaceLess]++;
            }
        }
        if (currentFreePlaceLess == countLess.length - 1) {
            currentFreePlaceLess = 0;
        } else {
            currentFreePlaceLess++;
        }
    }

    int getCountMoreThan(Fraction f) {
        int i = 0;
        for (Fraction fraction : selectedForMoreFraction) {
            if (fraction.equals(f)) {
                return countMore[i];
            }
            i++;
        }
        int cur = currentFreePlaceMore;
        calcCountMoreThan(f);
        selectedForMoreFraction[cur] = f;
        return countMore[cur];
    }

    int getCountLessThan(Fraction f) {
        int i = 0;
        for (Fraction fraction : selectedForLessFraction) {
            if (fraction.equals(f)) {
                return countLess[i];
            }
            i++;
        }
        int cur = currentFreePlaceLess;
        calcCountLessThan(f);
        selectedForLessFraction[cur] = f;
        return countLess[cur];
    }

    protected ArrayList<Fraction> getFractionList() {
        return fractionList;
    }

    public String toString() {
        String result = "";
        for (Fraction fraction : fractionList) {
            result += fraction.toString() + " ";
        }
        return result;
    }
}

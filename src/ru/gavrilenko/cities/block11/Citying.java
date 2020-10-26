package ru.gavrilenko.cities.block11;

import ru.gavrilenko.cities.block6.Cities;

public class Citying {
    public static void main(String[] args) {
        Cities c1 = new Cities("A");
        Cities c2 = new Cities("B");
        Cities c3 = new Cities("C");
        Cities c4 = new Cities("D");
        Cities c5 = new Cities("E");

        c1.addBinPath(c2, 2);
        c1.addBinPath(c3,5);
        c2.addUnPath(c3, 4);
        c2.addBinPath(c4,2);
        c4.addBinPath(c5, 5);
        c5.addUnPath(c3, 8);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
    }
}

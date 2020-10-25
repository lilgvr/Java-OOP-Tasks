import ru.gavrilenko.cities.block6.Cities;

public class Main {
    public static void main(String[] args) {
        Cities c1 = new Cities("A");
        Cities c2 = new Cities("B");
        Cities c3 = new Cities("C");
        c1.addBinPath(c2, 5);
        c1.addBinPath(c3, 5);
        c2.addUnPath(c3, 10);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        c1.removePath(c2);

        System.out.println(c1);
        System.out.println(c2);
    }
}

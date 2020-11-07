import practic.Name;
import practic.NameBuildable;

public class Main {
    public static void main(String[] args) {
        NameBuildable nb = Name.getBuilder();

        Name n1 = nb.setName("N1").setMidname("M1").getName();
        Name n2 = nb.setName("N2").getName();

        System.out.println(n1);
        System.out.println(n2);
    }

}

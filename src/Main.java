import java.util.function.Predicate;

import practic.univer.*;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> integerPredicate = x -> (x >= 2) && (x <=5);

        Student<Integer> student = new Student <>("Pete", integerPredicate, 6,7);

        System.out.println(student);

    }
}



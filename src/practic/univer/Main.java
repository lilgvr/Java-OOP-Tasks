package practic.univer;

import java.util.function.Predicate;

/**
 * <b>Главный класс для практических заданий</b>
 *
 * <ul>
 *     <li>Главный класс для заданий из задачника: {@link ru.Main}</li>
 * </ul>
 *
 * @author Дима
 */

public class Main {
    public static void main(String[] args) {
        String mark1 = "Зачет";
        String mark2 = "Незачет";

        Predicate <Integer> integerPredicate = x -> (x >= 2) && (x <= 5);
        Predicate <String> stringPredicate = s -> s.equals(mark1) || s.equals(mark2);

        Student <Integer> student1 = new Student <>("John", integerPredicate, 1, 2, 3, 4, 5, 6);
        Student <String> student2 = new Student <>("Mike", stringPredicate, mark1, mark2, "Mark");

        System.out.println(student1);
        System.out.println(student2);
    }
}

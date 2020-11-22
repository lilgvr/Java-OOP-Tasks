package practic.univer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Student<T> {
    private String name;
    private Predicate <T> limits;
    private List <T> marks;

    public Student(String name, Predicate <T> lims, T... marks) {

        if (name == null || name.equals("")) throw new IllegalArgumentException("У студента должно быть имя");
        this.name = name;
        this.marks = new ArrayList <>();
        if (lims != null) {
            this.limits = lims;
            addMarks(marks);
        } else {
            addAllMarks(marks);
        }

    }

    public String getName() {
        return name;
    }

    public List <T> getMarks() {
        return new ArrayList <>(marks);
    }

    private void addAllMarks(T... marks) {
        this.marks.addAll(Arrays.asList(marks));
    }

    public void addMarks(T... marks) {
        if (marks == null) throw new IllegalArgumentException("Null marks");

        int count = 0;
        StringBuilder s = new StringBuilder();

        for (T i : marks) {
            if (!limits.test(i)) {
                s.append(i).append(", ");
                count++;
            } else {
                this.marks.add(i);
            }
        }

        if (s.length() != 0 && count != marks.length) {
            s.delete(s.length() - 2, s.length());

            System.out.println(name + ": Были добавлены все оценки, кроме следующих: " + s);
        }

        if (count == marks.length) System.out.println(name + ": Ни одной оценки не было добавлено");

    }

    public String toString() {
        return (marks.size() > 0) ? name + ": " + marks : name + " - оценок нет";
    }
}

package ru.gavrilenko.person.block6;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Integer> marks = new ArrayList<>();

    public Student(String name, int... marks) {
        this.name = name;
        for (int i : marks)
            if (i < 2 || i > 5) throw new IllegalArgumentException("Некорректная оценка: " + i);
            else this.marks.add(i);
    }

    public String isExcellent() {
        return (isThisExcellent(marks)) ?
                name + " является отличником" :
                name + " не является отличником";
    }

    public void addMarks(int... marks) {
        for (int i : marks)
            if (i < 2 || i > 5) throw new IllegalArgumentException("Некорректная оценка: " + i);
            else this.marks.add(i);
    }

    private static boolean isThisExcellent(List<Integer> marks) {
        if (marks.size() == 0) return false;

        for (int i : marks) {
            if (i != 5) return false;
        }

        return true;
    }

    private double average(List<Integer> marks) {
        if (marks.size() == 0) return 0;

        double sum = 0;
        for (int i : marks) {
            sum += i;
        }
        return sum / marks.size();
    }

    public String getAverage() {
        return "Среднее значение оценок студента по имени " + name + ": " + average(marks);
    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");
        if (marks.size() != 0) {
            for (int i = 0; i < marks.size(); i++) {
                if (i != marks.size() - 1) s.append(marks.get(i)).append(", ");
                else s.append(marks.get(i)).append("]");
            }
        }

        return (marks.size() == 0) ? name + " - оценок нет" : name + ": " + s;
    }

}

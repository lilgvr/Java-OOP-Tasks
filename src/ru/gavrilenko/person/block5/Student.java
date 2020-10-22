package ru.gavrilenko.person.block5;

public class Student {
    private String name;
    private int[] marks;

    public Student(String name, int ...marks){
        this.name = name;
        this.marks = marks;
    }

    public String isExcellent(){
        return (isThisExcellent(marks))?
                name + " является отличником" :
                name + " не является отличником";
    }

    private static boolean isThisExcellent(int[] marks){
        if(marks.length == 0) return false;
        for(int i : marks){
            if(i != 5) return false;
        }

        return true;
    }

    private double average(int[] marks){
        if(marks.length == 0) return 0;

        double sum = 0;
        for(int i : marks){
            sum += i;
        }
        return sum/ marks.length;
    }

    public String getAverage(){
        return "Среднее значение оценок студента по имени " + name + ": " + average(marks);
    }

    public String toString(){
        String s = "[";
        if(marks.length != 0){
            for(int i = 0; i < marks.length; i++){
                if(i != marks.length - 1) s += marks[i] + ", ";
                else s += marks[i] + "]";
            }
        }

        return (marks.length == 0)? name + " - оценок нет": name + ": " + s;
    }

}


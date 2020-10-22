package ru.gavrilenko.person.block4;

public class Student {
    public String name;
    public int[] marks;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int ...marks){
        this.name = name;
        this.marks = marks;
    }

    public String toString(){
        String s = "";
        if(marks != null){
            for(int i = 0; i < marks.length; i++){
                if(i == marks.length - 1) s += Integer.toString(marks[i]);
                else s += marks[i] + ", ";
            }
        }
        return name + ": [" + s + "]";
    }
}

package ru.gavrilenko.person.block3;


public class Student {
    String name;
    int[] marks;

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

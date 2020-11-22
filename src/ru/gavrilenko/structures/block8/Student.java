package ru.gavrilenko.structures.block8;

import ru.gavrilenko.structures.block7.ChangeableArray;

public class Student {
    private String name;
    private ChangeableArray marks;

    public Student(String name){
        if(name == null || name.length() == 0) throw new IllegalArgumentException("Name is empty");

        this.name = name;
    }

    public Student(String name, int ...marks){
        if(name == null || name.length() == 0) throw new IllegalArgumentException("Name is empty");

        this.name = name;
        this.marks = new ChangeableArray();
        this.marks.insert(0, marks);
    }

    public Student(String name, ChangeableArray marks){
        if(name == null || name.length() == 0) throw new IllegalArgumentException("Name is empty");

        this.name = name;
        this.marks = new ChangeableArray();
        this.marks.insert(0, marks);
    }

    public void addMark(int mark){
        if(mark < 2 || mark > 5) throw new IllegalArgumentException("Illegal mark");

        this.marks.add(mark);
    }

    public void addMarks(ChangeableArray marks){
        for(int i : marks.asArray()){
            if(i < 2 || i > 5) throw new IllegalArgumentException("Illegal mark: " + i);
        }

        this.marks.insert(marks.size(), marks);
    }

    public void addMarks(int ...marks){
        for(int i : marks){
            if(i < 2 || i > 5) throw new IllegalArgumentException("Illegal mark: " + i);
        }

        this.marks.insert(marks.length, marks);
    }

    public ChangeableArray getMarks() {
        ChangeableArray res = new ChangeableArray();
        res.insert(0, marks);

        return res;
    }

    public double average(){
        if(marks.size() == 0) return 0;

        int sum = 0;

        for(int i : marks.asArray()) sum += i;

        return (double) sum/marks.size();
    }

    public String getName(){
        return name;
    }

    public boolean isExcellent(){
        if(marks.size() == 0) return false;

        for(int i : marks.asArray()){
            if(i != 5) return false;
        }

        return true;
    }

    public String toString(){
        StringBuilder res = new StringBuilder(name + ": [");

        for(int i = 0; i < marks.size(); i++){
            if(i == marks.size() - 1) res.append(marks.get(i)).append("]");
            else res.append(marks.get(i)).append(", ");
        }

        return res.toString();
    }

}

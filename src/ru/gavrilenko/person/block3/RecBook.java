package ru.gavrilenko.person.block3;


import java.util.ArrayList;
import java.util.List;

public class RecBook {
    private int n;
    private String name;
    private ArrayList<ArrayList<String>> info = new ArrayList<>();

    public RecBook(int n, String name){
        this.n = n;
        this.name = name;
    }

    public void addInfo(String discipline, String professor, int mark){
        if(mark <=0 || mark > 5) throw new IllegalArgumentException("Некорректная оценка");

        ArrayList<String> arr = new ArrayList<>();
        arr.add(discipline);
        arr.add(professor);
        arr.add(Integer.toString(mark));

        info.add(arr);
    }

    public void editInfo(String oldDiscipline, String newDiscipline, String newProfessor, int newMark){
        int index = 0;
        for(int i = 0; i < info.size(); i++){
            if(info.get(i).get(0) == oldDiscipline){
                index = i;
                break;
            }
        }

        if(index == -1)
            throw new IllegalArgumentException("Дисциплина не найдена");
        if(newMark <=0 || newMark > 5)
            throw new IllegalArgumentException("Некорректная оценка");

        ArrayList<String> arr = new ArrayList<>();
        arr.add(newDiscipline);
        arr.add(newProfessor);
        arr.add(Integer.toString(newMark));

        info.set(index, arr);
    }

    public void editMark(String discipline, int mark){
        int index = 0;
        for(int i = 0; i < info.size(); i++){
            if(info.get(i).get(0) == discipline){
                index = i;
                break;
            }
        }
        if(index == -1)
            throw new IllegalArgumentException("Дисциплина не найдена");
        if(mark <=0 || mark > 5)
            throw new IllegalArgumentException("Некорректная оценка");

        info.get(index).set(2, Integer.toString(mark));
    }

    public ArrayList<ArrayList<String>> getInfo() {
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        for(ArrayList<String> i : info){
            arr.add(i);
        }
        return arr;
    }

    public void setInfo(ArrayList<ArrayList<String>> info) {
        this.info = info;
    }

    public String toString(){
        String s = name + ", " + n + ":";
        String t = "";
        for(ArrayList<String> i : info){
            for(int j = 0; j < i.size(); j++){
                if(j == 0) t += "\t" + i.get(j) + ", ";
                else t += " " + i.get(j) + ", ";
            }
            t += "\n";
        }

        return s + "\n" + t;
    }
}

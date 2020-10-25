package ru.gavrilenko.cities.block3;

import java.util.ArrayList;

public class Cities {
    private String name;
    private ArrayList<ArrayList<Object>> paths = new ArrayList<>();

    public Cities(String name) {
        this.name = name;
    }

    public ArrayList<ArrayList<Object>> getPaths() {
        return paths;
    }

    public String getName() {
        return name;
    }

    public void addBinPath(Cities city, int cost){
        if(cost <= 0) throw new IllegalArgumentException("Некорректный путь");

        ArrayList<Object> arr = new ArrayList<>();
        ArrayList<Object> arr1 = new ArrayList<>();
        arr.add(city);
        arr.add(cost);

        arr1.add(this.name);
        arr1.add(cost);

        ArrayList<ArrayList<Object>> t = city.getPaths();
        t.add(arr1);

        paths.add(arr);
    }

    public void addUnPath(Cities city, int cost){
        if(cost <= 0) throw new IllegalArgumentException("Некорректный путь");

        ArrayList<Object> arr = new ArrayList<>();
        arr.add(city);
        arr.add(cost);

        paths.add(arr);
    }


    public String toString(){
        if(paths.size() == 0) return "Город " + name;

        StringBuilder s = new StringBuilder("Город " + name + ". Пути: \n");

        for(ArrayList<Object> i : paths){
            Cities t = (Cities)i.get(0);
            s.append(name).append(" -> ").append(t.name).append(", стоимость: ").append(i.get(1)).append("\n");
        }

        return s.toString();
    }

}

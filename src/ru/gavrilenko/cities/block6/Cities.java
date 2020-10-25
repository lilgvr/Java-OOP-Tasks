package ru.gavrilenko.cities.block6;

import java.util.ArrayList;

public class Cities {
    private String name;
    private ArrayList<ArrayList<Object>> paths = new ArrayList<>();

    public Cities(String name){
        this.name = name;
    }

    public Cities(String name, ArrayList<ArrayList<Object>> ps){
        this.name = name;
        this.paths = ps;
    }

    public ArrayList<ArrayList<Object>> getPaths() {
        return paths;
    }

    public void addBinPath(Cities city, int cost){
        if(cost <= 0) throw new IllegalArgumentException("Некорректный путь");
        if(city == this) throw new IllegalArgumentException();
        if(paths.contains(city)) throw new RuntimeException("В этот город уже есть дорога");

        for(ArrayList<Object> i : paths){
            Cities c = (Cities) i.get(0);
            if(c.name.equals(city.name)) throw new RuntimeException("В этот город уже есть дорога");
        }

        ArrayList<Object> arr = new ArrayList<>();
        ArrayList<Object> arr1 = new ArrayList<>();
        arr.add(city);
        arr.add(cost);

        arr1.add(this);
        arr1.add(cost);

        ArrayList<ArrayList<Object>> t = city.getPaths();
        t.add(arr1);

        paths.add(arr);
    }

    public void addUnPath(Cities city, int cost){
        if(cost <= 0) throw new IllegalArgumentException("Некорректный путь");
        if(city == this) throw new IllegalArgumentException();
        if(paths.contains(city)) throw new RuntimeException("В этот город уже есть дорога");

        for(ArrayList<Object> i : paths){
            Cities c = (Cities) i.get(0);
            if(c.name.equals(city.name)) throw new RuntimeException("В этот город уже есть дорога");
        }

        ArrayList<Object> arr = new ArrayList<>();
        arr.add(city);
        arr.add(cost);

        paths.add(arr);
    }

    public void removePath(Cities city){
        if(paths.removeIf(i -> i.contains(city))){
            return;
        }

        boolean isPathBin = false;

        for(ArrayList<Object> j : city.paths){ // удаление в обоих городах ?
            Cities c = (Cities) j.get(0);

            if(c.name.equals(this.name) || j.contains(this)){
                isPathBin = true;
                break;
            }
        }

        for(ArrayList<Object> i : paths){
            Cities c = (Cities) i.get(0);

            if(c.name.equals(city.name)){
                paths.remove(i);
                if(isPathBin){
                    city.removePath(this);
                }

                return;
            }
        }

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

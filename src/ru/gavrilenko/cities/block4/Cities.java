package ru.gavrilenko.cities.block4;

import java.util.ArrayList;

public class Cities {
    private String name;
    private ArrayList<ArrayList<String>> paths = new ArrayList<>();

    public Cities(String name) {
        this.name = name;
    }


    public ArrayList<ArrayList<String>> getPaths() {
        return paths;
    }

    public void addBinPath(Cities city, int cost){
        if(cost < 0) throw new IllegalArgumentException("Некорректный путь");
        ArrayList<String> arr = new ArrayList<>();
        ArrayList<String> arr1 = new ArrayList<>();
        arr.add(city.name);
        arr.add(Integer.toString(cost));

        arr1.add(this.name);
        arr1.add(Integer.toString(cost));

        ArrayList<ArrayList<String>> t = city.getPaths();
        t.add(arr1);

        paths.add(arr);
    }

    public void addUnPath(Cities city, int cost){
        if(cost < 0) throw new IllegalArgumentException("Некорректный путь");
        ArrayList<String> arr = new ArrayList<>();
        arr.add(city.name);
        arr.add(Integer.toString(cost));

        paths.add(arr);
    }



    public String toString(){
        String s = "";
        for(ArrayList<String> i : paths){
            for(int j = 0; j < i.size(); j++){
                if(j != i.size() - 1){
                    s += i.get(j) + ": ";
                }else{
                    s += i.get(j);
                }
            }
            s += "\n";
        }

        return name + ". Пути:\n" + s;
    }

}

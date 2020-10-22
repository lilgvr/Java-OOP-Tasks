package ru.gavrilenko.cities.block6;

public class House {
    private int floors;

    public House(int floors){
        if(floors <= 0) throw new IllegalArgumentException("У дома должно быть положительное количество этажей");
        this.floors = floors;
    }

    public String toString(){
        return (floors%10 == 1)? "Дом с " + floors + " этажом": "Дом с " + floors + " этажами";
    }
}

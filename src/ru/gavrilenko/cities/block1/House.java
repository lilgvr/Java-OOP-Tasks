package ru.gavrilenko.cities.block1;

public class House {
    public int floors;

    public String toString(){
        return (floors%10 == 1)? "Дом с " + floors + " этажом": "Дом с " + floors + " этажами";
    }
}

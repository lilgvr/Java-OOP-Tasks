package ru.gavrilenko.cities.block4;

public class House {
    private int floors;

    static{
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
    }

    public House(int floors){
        this.floors = floors;
    }

    public String toString(){
        return (floors%10 == 1)? "Дом с " + floors + " этажом": "Дом с " + floors + " этажами";
    }
}

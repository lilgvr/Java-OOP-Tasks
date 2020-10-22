package ru.gavrilenko.person.block2;

public class Dept {
    public String name;
    public Worker boss;

    public String toString(){
        return boss == null ? name : name + ", Начальник: " + boss;
    }
}

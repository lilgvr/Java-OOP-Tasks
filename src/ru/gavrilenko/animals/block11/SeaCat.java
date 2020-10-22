package ru.gavrilenko.animals.block11;

public class SeaCat implements Meowable{
    private String name;

    public SeaCat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + ": SeaMeow");
    }


}

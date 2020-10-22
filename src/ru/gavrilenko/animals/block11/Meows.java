package ru.gavrilenko.animals.block11;

public class Meows {
    public static void meowAll(Meowable ...arr){
        for(Meowable i : arr){
            i.meow();
        }
    }
}

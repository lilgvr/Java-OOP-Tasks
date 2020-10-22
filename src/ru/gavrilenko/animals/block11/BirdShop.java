package ru.gavrilenko.animals.block11;

import ru.gavrilenko.animals.block11.Bird;

public class BirdShop {
    public static void singAll(Bird ...birds){
        for(Bird i : birds){
            i.sing();
        }
    }
}

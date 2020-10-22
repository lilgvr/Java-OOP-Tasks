package ru.gavrilenko.person.block2;

import ru.gavrilenko.person.block1.Name;

public class Person {
    public Name info = new Name();
    public int height;

    public String toString(){
       return info + ", рост: " + height;
    }
}

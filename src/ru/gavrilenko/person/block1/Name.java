package ru.gavrilenko.person.block1;

public class Name {
    public String name, midname, surname;

    public String toString(){
        String s = "";
        if(name != null) s+= name + " ";
        if(midname != null) s+= midname + " ";
        if (surname != null) s += surname;
        return s;
    }
}

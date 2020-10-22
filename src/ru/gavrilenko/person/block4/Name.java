package ru.gavrilenko.person.block4;

public class Name {
    public String name, midname,surname;


    public Name(String name) {
        this.name = name;
    }

    public Name(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Name(String name, String midname, String surname) {
        this.name = name;
        this.midname = midname;
        this.surname = surname;
    }

    public String toString(){
        return (midname == null)? (surname == null)? name : name + ' ' + surname : name + ' ' + midname + ' ' + surname;
    }
}

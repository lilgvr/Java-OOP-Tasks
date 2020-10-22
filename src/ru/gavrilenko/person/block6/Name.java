package ru.gavrilenko.person.block6;

public class Name {
    private String name, midname, surname;

    public Name(String name) {
        if(name == "") throw new IllegalArgumentException("Имя не может быть пустым");
        this.name = name;
    }

    public Name(String name, String surname) {
        if(name == "") throw new IllegalArgumentException("Имя не может быть пустым");
        this.name = name;
        this.surname = surname;
    }

    public Name(String name, String midname, String surname) {
        if(name == "") throw new IllegalArgumentException("Имя не может быть пустым");
        this.name = name;
        this.midname = midname;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getMidname() {
        return midname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        if(name == "") throw new IllegalArgumentException("Имя не может быть пустым");
        this.name = name;
    }

    public void setMidname(String midname) {
        if(midname == "") throw new IllegalArgumentException("Отчество не может быть пустым");
        this.midname = midname;
    }

    public void setSurname(String surname) {
        if(surname == "") throw new IllegalArgumentException("Фамилия не может быть пустой");
        this.surname = surname;
    }

    public String toString(){
        return (midname == null)? (surname == null)? name : name + ' ' + surname : name + ' ' + midname + ' ' + surname;
    }
}

package ru.gavrilenko.person.block4;

public class Person {
    public Name info;
    public int height;
    public Person father;

    public Person(String name, int height){
        this.info = new Name(name);
        this.height = height;
    }

    public Person(String name, int height, Person father){
        this.info = new Name(name);
        this.height = height;
        this.father = father;
    }

    public Person(Name info, int height){
        this.info = info;
        this.height = height;
    }

    public Person(Name info, int height, Person father){
        this.info = info;
        if(info.midname == null){
            this.info.midname = father.info.name + "ович";
        }
        if(info.surname == null){
            this.info.surname = father.info.surname;
        }

        this.height = height;
        this.father = father;

    }

    public String toString(){
        return (father == null)?  info + ", " + height :  info + ", " + height + ", отец: " + father;
    }

}

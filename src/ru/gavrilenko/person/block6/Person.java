package ru.gavrilenko.person.block6;

public class Person {
    private Name info;
    private int height;
    private Person father;

    public Person(String name, int height){
        this.info = new Name(name);
        if(height <=0 || height >500) throw new IllegalArgumentException();
        this.height = height;
    }

    public Person(String name, int height, Person father){
        this.info = new Name(name);
        this.height = height;
        this.father = father;

        if(height <=0 || height >500) throw new IllegalArgumentException();
    }

    public Person(Name info, int height){
        this.info = info;
        this.height = height;

        if(height <=0 || height >500) throw new IllegalArgumentException();
    }

    public Person(Name info, int height, Person father){
        this.info = info;
        if(info.getMidname() == null){
            this.info.setMidname(father.info.getName() + "ович");
        }
        if(info.getSurname() == null){
            this.info.setSurname(father.info.getSurname());
        }

        this.height = height;
        this.father = father;

        if(height <=0 || height >500) throw new IllegalArgumentException();

    }

    public Person getFather() {
        return father;
    }

    public Name getInfo() {
        return info;
    }

    public String getName(){
        return info.getName();
    }

    public void setName(String name, String midname, String surname){
        this.info = new Name(name, midname, surname);
    }

    public void setName(String name){
        this.info = new Name(name);
    }

    public void setName(String name, String surname){
        this.info = new Name(name, surname);
    }

    public String toString(){
        return (father == null)?  info + ", " + height :  info + ", " + height + ", отец: " + father;
    }
}

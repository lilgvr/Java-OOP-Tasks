package ru.gavrilenko.person.block2;

import ru.gavrilenko.person.block1.Name;

public class PersonWFather {
    public Name info = new Name();
    public int height;
    public PersonWFather father;

    private void edit(){
        if(info.surname == null && father.info.surname != null) info.surname = father.info.surname;
        if(info.midname == null && father.info.name != null) info.midname = father.info.name + "ович";
    }


    public String toString(){
        edit();
        return (father != null)?info + ", рост: " + height + ". Отец: " + father : info + ", рост: " + height;
    }
}

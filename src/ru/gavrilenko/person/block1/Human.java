package ru.gavrilenko.person.block1;

public class Human {
    public String name;
    public int height;

    public String toString(){
        if(height < 160) return name + " - низкий человек";
        if(height > 185) return name + " - высокий человек";
        return name + " - обычный человек";
    }
}

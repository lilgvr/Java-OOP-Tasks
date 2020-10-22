package ru.gavrilenko.person.block2;

public class Worker {
    public String name;
    public Dept dept;

    public String toString(){
        if(dept.boss == null) return name + " работает в отделе " + dept;
        return (this == dept.boss)?
                name + " - начальник отдела " + dept :
                name + " работает в отделе " + dept + ", начальник - " + dept.boss.name;
    }
}

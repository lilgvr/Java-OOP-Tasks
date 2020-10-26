package ru.gavrilenko.person.block6;

import java.util.ArrayList;

public class Dept {
    String name;
    Worker boss;
    ArrayList<Worker> workers = new ArrayList<>();

    public Dept(String name){
        this.name = name;
    }

    public Dept(String name, Worker boss){
        this.name = name;
        this.boss = boss;

        this.boss.setDept(this);
        this.workers.add(boss);
    }

    public void removeBoss(){
        this.boss.removeDept();
        workers.remove(boss);
        this.boss = null;
    }

    public void setBoss(Worker boss) {
        if(boss.getDept() != null){
            boss.getDept().removeBoss(); // не может быть начальником в двух отделах
        }

        this.boss = boss;
        this.boss.setDept(this);

        workers.add(boss);
    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

    public Worker getBoss() {
        return boss;
    }

    public String toString(){
        return boss == null ? name : name + ", Начальник: " + boss;
    }

}

package ru.gavrilenko.person.block8;

import java.util.ArrayList;
import java.util.List;

public class Dept {
    private String name;
    private Worker boss;
    private List<Worker> workers;

    public Dept(String name, Worker boss) {
        if(name == null || boss == null || name.equals("")) throw new IllegalArgumentException("Invalid dept");

        this.name = name;
        this.boss = boss;
        boss.changeDept(this);
        this.workers = new ArrayList<>();
        this.workers.add(boss);
    }

    public void recruit(Worker worker){
        if(workers.contains(worker)) return;

        worker.changeDept(this);
        workers.add(worker);
    }

    public void fire(Worker worker){
        if(!workers.contains(worker)) return;
        if(worker.equals(boss)) return;

        worker.changeDept(null);
        workers.remove(worker);
    }

    public void changeBoss(Worker newBoss){
        if(newBoss == null) return;

        this.boss = newBoss;
        if(!workers.contains(newBoss)) workers.add(newBoss);
    }

    public String getName() {
        return name;
    }

    public List<Worker> getWorkers() {
        return new ArrayList<>(workers);
    }

    public Worker getBoss() {
        return boss;
    }

    public String toString(){
        return "Отдел: " + name + ". Начальник: " + boss.getName();
    }
}

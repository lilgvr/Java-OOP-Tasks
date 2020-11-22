package ru.gavrilenko.person.block8;

public class Worker {
    private String name;
    private Dept dept;

    public Worker(String name) {
        if(name == null || name.equals("")) throw new IllegalArgumentException("Empty name");

        this.name = name;
    }

    public void changeDept(Dept dept){

        this.dept = dept;
    }

    public void fire(){
        if(dept == null) return;

        dept.fire(this);
    }

    public void recruit(Dept dept){
        dept.recruit(this);
    }

    public String getName() {
        return name;
    }

    public String toString(){
        if(dept != null && dept.getBoss() == null) return name + " работает в отделе " + dept.getName();

        if(dept != null && this.equals(dept.getBoss())) return name + " - начальник отдела " + dept.getName();


        if(dept != null) return name + " работает в отделе " + dept.getName() + ", начальник - " + dept.getBoss().name;

        return name;
    }
}

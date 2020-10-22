package ru.gavrilenko.person.block6;

public class Worker {
    private String name;
    private Dept dept;

    public Worker(String name, Dept dept) {
        this.name = name;
        this.dept = dept;
        this.dept.addWorker(this);
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept){
        this.dept = dept;
    }

    public void removeDept(){
        this.dept = null;
    }

    public String toString(){
        if(dept.getBoss() == null) return name + " работает в отделе " + dept;
        return (this == dept.getBoss())?
                name + " - начальник отдела " + dept :
                name + " работает в отделе " + dept + ", начальник - " + dept.getBoss();
    }
}


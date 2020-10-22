package ru.gavrilenko.animals.block5;

public class Cat {
    private String name;

    public Cat(String name){
        this.name = name;
    }

    public void meow(){
        System.out.println(name + ": Meow");
    }

    public void meow(int n){
        if(n == 1){
            meow();
            return;
        }
        String s = name + ": ";

        for(int i = 0; i < n; i++){
            if(i != n - 1) s += "мяу-";
            else s += "мяу";
        }
        System.out.println(s);
    }
}

package ru.gavrilenko.structures.block7;

import java.util.ArrayList;

public class Secret {
    private String text;
    private String holder;
    private int count = 0;
    private ArrayList<String> holders = new ArrayList<>();

    public Secret(String text, String holder){
        if(text == null || holder == null) throw new IllegalArgumentException("Null is as argument");

        this.holders.add(holder);
        this.text = text;
        this.holder = holder;
    }

    public Secret(Secret secret, String holder){
        if(secret == null) throw new IllegalArgumentException("Source secret is null");

        this.holder = holder;

        secret.count++;
        System.out.println(secret.holder + " сказал, что " + secret.text);
        this.text = addSymbols(secret.text);
    }

    private String addSymbols(String str){
        StringBuilder res = new StringBuilder(str);

        int n = str.length()/10;
        int opt = (int) (Math.random() * 3);

        for(int i = 0; i < n; i++){
            switch (opt) {
                case 0 -> res.setCharAt((int)(Math.random() * (n + 1)), (char) (101 + Math.random() * 133));
                case 1 -> res.setCharAt((int)(Math.random() * (n + 1)), (char) (141 + Math.random() * 173));
                case 2 -> res.setCharAt((int)(Math.random() * (n + 1)), (char)(48 + Math.random()*58));
            }
        }

        return res.toString();
    }

    String getText() {
        return text;
    }

    String getHolder() {
        return holder;
    }

    public int getCount() {
        return count;
    }

    public String toString(){
        return holder + " : Это секрет!";
    }
}

package ru.gavrilenko.structures.block7;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<List<String>> phones = new ArrayList<>();

    public String addPhone(String phone, String name){
        int check = checkName(name);
        if(check < 0){
            List<String> res = new ArrayList<>();
            res.add(phone);
            res.add(name);
            phones.add(res);

            return null;
        }

        String tmp = phones.get(check).get(0);
        phones.get(check).set(0, phone);
        return tmp;
    }

    public void del(String name){
        int target = checkName(name);
        if(target < 0){
            System.out.println("404");
            return;
        }

        phones.remove(target);
    }

    public String getPhone(String name){
        int target = checkName(name);
        if(target < 0){
            return null;
        }

        return phones.get(target).get(0);
    }

    protected int checkName(String name){
        for(int i = 0; i < phones.size(); i++){
            if(phones.get(i).get(1).equals(name)) return i;
        }

        return -1;
    }

    public String[] getAll(){
        if(phones.size() == 0) return null;

        String[] res = new String[phones.size()];

        for(int i = 0; i < phones.size(); i++){
            res[i] = phones.get(i).get(0) + " - " + phones.get(i).get(1);
        }

        return res;
    }

    public String[] getPhones(){
        if(phones.size() == 0) return null;
        String[] res = new String[phones.size()];

        for(int i = 0; i < phones.size(); i++){
            res[i] = phones.get(i).get(0);
        }

        return res;
    }

    public String[] getNames(){
        if(phones.size() == 0) return null;
        String[] res = new String[phones.size()];

        for(int i = 0; i < phones.size(); i++){
            res[i] = phones.get(i).get(1);
        }

        return res;
    }

    public String[] getNames(String part){
        if(part == null) throw new IllegalArgumentException();

        String[] res = new String[phones.size()];
        int ptr = 0;

        for (List<String> phone : phones) {
            String tmp = phone.get(1);
            if (tmp.startsWith(part)) res[ptr++] = tmp;
        }

        if((res.length == 0)){
            System.out.println("No such names were found, returned all values");
            return getNames();
        }

        if(res[ptr] == null){
            String[] temp = new String[ptr];
            System.arraycopy(res, 0, temp, 0, ptr);
            return temp;
        }

        return res;
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        for(List<String> i : phones){
            res.append(i.get(0)).append(" - ").append(i.get(1)).append("\n");
        }

        return (phones.size() > 0)? res.toString() : "Empty";

    }
}

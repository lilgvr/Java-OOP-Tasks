package ru.gavrilenko.structures.block7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhonebookEnhanced extends Phonebook{
    // 1: List of all contacts, 2: List of contact elements, 3: List of
    private List<List<List<String>>> phones = new ArrayList<>();

    public List<String> addPhones(String name, String ...phones){
        int check = checkName(name);
        if(check < 0){
            List<String> res = new ArrayList<>();
            Collections.addAll(res, phones);
            res.add(name);

            return null;
        }

        List<String> tmp = new ArrayList<>();
//        this.phones.get();

        for(int i = 0; i < this.phones.size(); i++){

        }

        return tmp;
    }
}

package ru.gavrilenko.structures.block7;

public class UniqueStringArray {
    private String[] arr;
    private int size;

    public UniqueStringArray(){}

    public UniqueStringArray(UniqueStringArray array){
        try{
            this.arr = new String[array.size];
            this.size = array.size;

            System.arraycopy(array.asArray(), 0, this.arr,0,array.size);
            delDuplicates();

        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public void add(String str){
        if(find(str) != -1){
            System.out.println("String almost is in array ");
            return;
        }

        try{
            String[] tmp = arr;

            arr = new String[size + 1];

            System.arraycopy(tmp, 0, arr, 0, size);

            arr[size + 1] = str;

            size++;

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public void insert(int index, String str){
        if(find(str) != -1){
            System.out.println("String almost is in array ");
            return;
        }

        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        try{
            String[] res = new String[size + 1];
            String[] tmp = new String[index];

            System.arraycopy(arr, 0, tmp, 0, tmp.length);

            System.arraycopy(tmp, 0, res, 0, tmp.length);

            res[index] = str;

            if (res.length - index + 1 >= 0)
                System.arraycopy(arr, index + 1, res, index + 1, res.length - index + 1);

            arr = res;
            size++;

        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    public void insert(int index, String ...array){
        try{
            String[] temp = array.clone();

            for(int i = 0; i < temp.length; i++){
                if(find(array[i]) != -1){
                    delInArray(temp, i);
                }
            }

            if(temp.length == 0) return;


            if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

            String[] res = new String[size + array.length];
            String[] tmp = new String[index];

            System.arraycopy(arr, 0, tmp, 0, tmp.length);

            System.arraycopy(tmp, 0, res, 0, tmp.length);

            if (res.length - index >= 0)
                System.arraycopy(array, 0, res, index, res.length - index);

            arr = res;
            size += array.length;

        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public void insert(int index, UniqueStringArray array){
        try{
            String[] temp = array.arr.clone();

            for(int i = 0; i < temp.length; i++){
                if(find(temp[i]) != -1){
                    delInArray(temp, i);
                }
            }

            if(temp.length == 0) return;


            if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

            String[] res = new String[size + array.size];
            String[] tmp = new String[index];

            System.arraycopy(arr, 0, tmp, 0, tmp.length);

            System.arraycopy(tmp, 0, res, 0, tmp.length);

            if (res.length - index >= 0)
                System.arraycopy(array.asArray(), 0, res, index, res.length - index);

            arr = res;
            size += array.size;

        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    private int[] getCount(){
        int[] count = new int[size];

        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                if(arr[i].equals(arr[j])) count[i]++;
            }
        }

        return count;
    }

    private void delDuplicates(){
        int[] count = getCount();

        for(int i = 0; i < size; i++){
            if(count[i] > 1) del(i);
        }

    }

    public int find(String str){
        for(int i = 0; i < size; i++){
            if(arr[i].equals(str)) return i;
        }

        return -1;
    }

    private void delInArray(String[] array, int index){
        if(index < 0 || index >= arr.length) return;

        String[] res = new String[array.length - 1];

        System.arraycopy(array, 0, res, 0, index);

        if (res.length - index + 1 >= 0)
            System.arraycopy(array, index + 1 - 1, res, index + 1, res.length - index + 1);

        System.arraycopy(res, 0, array, 0, res.length);
    }

    public void del(int index){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        String[] res = new String[size - 1];

        System.arraycopy(arr, 0, res, 0, index);

        if (res.length - index + 1 >= 0)
            System.arraycopy(arr, index + 1, res, index + 1 - 1, res.length - index + 1);

        arr = res;
        size--;
    }

    public int del(String ...array){
        try{
            int counter = 0;

            for (String s : array) {
                if (find(s) != -1) {
                    del(find(s));
                    counter++;
                }
            }

            size -= counter;

            return counter;

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public int getSize() {
        return size;
    }

    public String[] asArray(){
        return arr.clone();
    }

    public String toString(){
        StringBuilder res = new StringBuilder("[");

        if(size == 0){
            return "Empty";
        }

        for(int i = 0; i < size; i++){
            if(i != size - 1){
                res.append(arr[i]).append(",");
            }else{
                res.append(arr[i]).append("]");
            }
        }

        return res.toString();
    }
}

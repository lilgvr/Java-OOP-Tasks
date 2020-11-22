package ru.gavrilenko.structures.block7;

public class ChangeableArray {
    private int[] arr;
    private int size = 0;

    public ChangeableArray(){}

    public ChangeableArray(int ...array){
        this.arr = new int[array.length];

        System.arraycopy(array, 0, this.arr, 0, array.length);
        this.size = arr.length;
    }

    public ChangeableArray(ChangeableArray array){
        try{
            this.arr = new int[array.size];
            System.arraycopy(array.asArray(), 0, this.arr, 0, array.size);
            this.size = this.arr.length;

        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public void add(int number){
        int[] tmp = arr;

        arr = new int[size + 1];

        System.arraycopy(tmp, 0, arr, 0, tmp.length);

        arr[tmp.length + 1] = number;

        size++;
    }

    public void insert(int index, int number){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        int[] res = new int[size + 1];
        int[] tmp = new int[index];

        System.arraycopy(arr, 0, tmp, 0, tmp.length);

        System.arraycopy(tmp, 0, res, 0, tmp.length);

        res[index] = number;

        if (res.length - index + 1 >= 0)
            System.arraycopy(arr, index + 1, res, index + 1, res.length - index + 1);

        arr = res;
        size = arr.length;
    }

    public void insert(int index, int ...array){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        int[] res = new int[size + array.length];
        int[] tmp;
        if(index > 0) { //TODO
            tmp = new int[index];
            System.arraycopy(arr, 0, tmp, 0, tmp.length);
            System.arraycopy(tmp, 0, res, 0, tmp.length);
        }

        if (res.length - index >= 0)
            System.arraycopy(array, 0, res, index, res.length - index);

        arr = res;
        size = arr.length;
    }

    public void insert(int index, ChangeableArray array){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        int[] res = new int[size + array.asArray().length];
        int[] tmp = new int[index];

        System.arraycopy(arr, 0, tmp, 0, tmp.length);

        System.arraycopy(tmp, 0, res, 0, tmp.length);

        if (res.length - index >= 0)
            System.arraycopy(array.asArray(), 0, res, index, res.length - index);

        arr = res;
        size = arr.length;
    }

    public void del(int index){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        int[] res = new int[size - 1];

        if(index == 0){
            System.arraycopy(arr, 1, res, 0, arr.length -1);
            arr = res.clone();
            size--;
            return;
        }

        if(index == arr.length - 1){
            System.arraycopy(arr, 0, res, 0, arr.length - 1);
            arr = res.clone();
            size--;
            return;
        }

        System.arraycopy(arr, 0, res, 0, index);
        System.arraycopy(arr, index + 1, res, index, arr.length - index - 1);

        arr = res.clone();
        size--;
    }

    public int get(int index){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        return arr[index];
    }

    public void set(int index, int number){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        arr[index] = number;
    }

    public int[] asArray(){
        return arr.clone();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public String toString(){
        StringBuilder res = new StringBuilder("[");

        if(isEmpty()){
            return "Empty";
        }

        for(int i : arr){
            res.append(i).append(", ");
        }

        res.delete(res.length() - 2, res.length());
        res.append("]");

        return res.toString();
    }
}

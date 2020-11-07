package ru.gavrilenko.structures.block7;

public class UnchangeableArray {
    private int[] arr;

    public UnchangeableArray(int ...array){
        this.arr = new int[array.length];

        System.arraycopy(array, 0, this.arr, 0, array.length);
    }

    public UnchangeableArray(UnchangeableArray array){
        try{
            this.arr = new int[array.asArray().length];

            System.arraycopy(array.asArray(), 0, this.arr, 0, array.arr.length);
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    public int get(int index){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        return arr[index];
    }

    public void set(int index, int number){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        arr[index] = number;
    }

    public boolean isEmpty(){
        return arr.length == 0;
    }

    public int size(){
        return arr.length;
    }

    public int[] asArray(){
        return arr.clone();
    }

    public String toString(){
        StringBuilder res = new StringBuilder("[");

        if(isEmpty()){
            return "Empty";
        }

        for(int i = 0; i < size(); i++){
            if(i != size() - 1){
                res.append(arr[i]).append(",");
            }else{
                res.append(arr[i]).append("]");
            }
        }

        return res.toString();
    }
}

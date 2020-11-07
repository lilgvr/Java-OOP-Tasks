package ru.gavrilenko.structures.block7;

public class NonExtendableArray {
    private int[] arr;
    private int max;
    private int size = 0;

    public NonExtendableArray() {
        this.arr = new int[100];
        this.size = 100;
    }
    public NonExtendableArray(int max) {
        if(max < 0) throw new IllegalArgumentException("Invalid maximum");

        this.max = max;
        this.arr = new int[max];
    }

    public NonExtendableArray(NonExtendableArray array){
        this.max = array.asArray().length;
        this.arr = new int[max];
        this.size = this.arr.length;

        System.arraycopy(array.arr, 0, this.arr, 0, max);
    }

    public void add(int number){
        if(size() == max) throw new RuntimeException("Array is full");

        int[] tmp = arr;

        arr = new int[size() + 1];

        System.arraycopy(tmp, 0, arr, 0, tmp.length);

        arr[tmp.length + 1] = number;

        size = arr.length;
    }

    public void insert(int index, int number){
        if(size == max) throw new RuntimeException("Array is full");
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
        if(size == max) throw new RuntimeException("Array is full");
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        int[] res = new int[size + array.length];
        int[] tmp = new int[index];

        System.arraycopy(arr, 0, tmp, 0, tmp.length);

        System.arraycopy(tmp, 0, res, 0, tmp.length);

        if (res.length - index >= 0)
            System.arraycopy(array, 0, res, index, res.length - index);

        arr = res;
        size = arr.length;
    }

    public void insert(int index, NonExtendableArray array){
        if(size == max) throw new RuntimeException("Array is full");
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        int[] res = new int[size + array.arr.length];
        int[] tmp = new int[index];

        System.arraycopy(arr, 0, tmp, 0, tmp.length);

        System.arraycopy(tmp, 0, res, 0, tmp.length);

        if (res.length - index >= 0)
            System.arraycopy(array.arr, 0, res, index, res.length - index);

        arr = res;
        size = arr.length;
    }

    public void del(int index){
        if(index < 0 || index >= arr.length) throw new IllegalArgumentException("Invalid index");

        int[] res = new int[size - 1];

        System.arraycopy(arr, 0, res, 0, index);

        if (res.length - index + 1 >= 0)
            System.arraycopy(arr, index + 1, res, index + 1 - 1, res.length - index + 1);

        arr = res;
        size = arr.length;
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
        return size == 0;
    }

    public boolean isFull(){
        return size == max;
    }

    public int size(){
        return size;
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

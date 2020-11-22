package ru;

public class MyArray<E> {
    private Object[] arr;

    public MyArray(E... arr) {
        this.arr = arr.clone();
    }

    public MyArray(MyArray<E> array) {
        this.arr = array.toArray().clone();
    }

    public void add(E obj) {
        E[] res = (E[]) new Object[arr.length + 1];

        System.arraycopy(arr, 0, res, 0, arr.length);

        res[arr.length] = obj;

        arr = res.clone();
    }

    public E[] toArray() {
        if (arr.length == 0) throw new ArrayStoreException("Empty array");

        return (E[]) arr.clone();
    }

    public int size() {
        return arr.length;
    }

    public void add(E... array) {
        E[] res = (E[]) new Object[arr.length + array.length];
        System.arraycopy(arr, 0, res, 0, arr.length);
        System.arraycopy(array, 0, res, arr.length, array.length);

        arr = res.clone();
    }

    public void add(MyArray<E> array) {
        E[] res = (E[]) new Object[arr.length + array.size()];

        System.arraycopy(arr, 0, res, 0, arr.length);
        System.arraycopy(array.toArray(), 0, res, arr.length, array.size());

        arr = res.clone();
    }

    public void del(int index) {
        if (index < 0 || index >= arr.length)
            throw new IllegalArgumentException("Invalid index", new ArrayIndexOutOfBoundsException());

        if (size() == 0) return;

        E[] res = (E[]) new Object[arr.length - 1];

        if (index == 0) {
            System.arraycopy(arr, 1, res, 0, arr.length - 1);
            arr = res.clone();
            return;
        }

        if (index == arr.length - 1) {
            System.arraycopy(arr, 0, res, 0, arr.length - 1);
            arr = res.clone();
            return;
        }

        System.arraycopy(arr, 0, res, 0, index);
        System.arraycopy(arr, index + 1, res, index, arr.length - index - 1);

        arr = res.clone();
    }

    public void del(int start, int end) {
        if (start < 0 || end >= size() || start > end) {
            throw new IllegalArgumentException("Invalid argument");
        }

        if (size() == 0) return;

        if (start == end) {
            del(start);
            return;
        }

        E[] res = (E[]) new Object[size() - end + start - 1];

        System.arraycopy(arr, 0, res, 0, start);
        System.arraycopy(arr, end + 1, res, start, size() - end - 1);

        arr = res.clone();
    }

    public void del(E obj) {
        if (indexOf(obj) < 0) return;
        if (size() == 0) return;

        del(indexOf(obj));
    }

    public void insert(int index, E obj) {
        if (obj == null) throw new IllegalArgumentException("Object is null");
        if (index < 0 || index >= size()) throw new IllegalArgumentException("Invalid index");


        E[] res = (E[]) new Object[size() + 1];

        if (index == 0) {
            res[0] = obj;
            System.arraycopy(arr, 0, res, 1, arr.length);
            arr = res.clone();
            return;
        }

        if (index == arr.length - 1) {
            add(obj);
            return;
        }

        System.arraycopy(arr, 0, res, 0, index);
        res[index] = obj;
        System.arraycopy(arr, index, res, index + 1, size() - index);

        arr = res.clone();
    }

    public void insert(int index, E... array) {
        if (array == null) throw new IllegalArgumentException("Array is null");

        if (index < 0 || index >= size()) throw new IllegalArgumentException();

        E[] res = (E[]) new Object[size() + array.length];

        if (index == arr.length - 1) {
            add(array);
            return;
        }

        if (index == 0) {
            System.arraycopy(array, 0, res, 0, array.length);
            System.arraycopy(arr, 0, res, array.length, arr.length);

            arr = res.clone();
            return;
        }

        System.arraycopy(arr, 0, res, 0, index);
        System.arraycopy(array, 0, res, index, array.length);
        System.arraycopy(arr, index, res, array.length + index, arr.length - index);

        arr = res.clone();
    }

    public void insert(int index, MyArray<E> array) {
        if (array == null) throw new IllegalArgumentException("Array is null");

        if (index < 0 || index >= size()) throw new IllegalArgumentException();

        E[] res = (E[]) new Object[size() + array.size()];

        if (index == arr.length - 1) {
            add(array);
            return;
        }

        if (index == 0) {
            System.arraycopy(array.toArray(), 0, res, 0, array.size());
            System.arraycopy(arr, 0, res, array.size(), arr.length);

            arr = res.clone();
            return;
        }

        System.arraycopy(arr, 0, res, 0, index);
        System.arraycopy(array.toArray(), 0, res, index, array.size());
        System.arraycopy(arr, index, res, array.size() + index, arr.length - index);

        arr = res.clone();
    }

    public E get(int index) {
        if (index < 0 || index >= size()) throw new IllegalArgumentException();

        return (E) arr[index];
    }

    public MyArray<E> get(int start, int end) {
        if (start < 0 || end >= size() || start > end) {
            throw new IllegalArgumentException("Invalid argument");
        }

        E[] res = (E[]) new Object[end - start + 1];

        if (start == end) {
            res[0] = (E) arr[start];
            return new MyArray<>((E) arr[start]);
        }

        System.arraycopy(arr, start, res, 0, end - start + 1);

        return new MyArray<>(res);
    }

    public int indexOf(E obj) {
        if (obj == null) return -2;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(obj)) return i;
        }

        return -1;
    }

    public boolean contains(E obj) {
        if (obj == null) return false;
        return indexOf(obj) >= 0;
    }

    public String toString() {
        if (size() == 0) return "Empty";

        StringBuilder res = new StringBuilder("[");
        for (Object i : arr) {
            res.append(i).append(", ");
        }

        res.delete(res.length() - 2, res.length());
        res.append("]");

        return res.toString();
    }
}

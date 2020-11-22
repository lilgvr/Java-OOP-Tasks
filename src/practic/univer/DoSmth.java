package practic.univer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class DoSmth<T, R> {

    /*
     * =========================================================================
     * Main method
     * =========================================================================
     * */

    public static void main(String[] args) {
        DoSmth <String, Integer> ds = new DoSmth <>();

        String[] arr = {"1", "2", "3", "4040"};

        ArrayList <String> l1 = new ArrayList <>(Arrays.asList(arr));

        Function <String, Integer> function = Integer::parseInt;

        System.out.println(ds.modifyList(l1, function));

    }

    /*
     * =========================================================================
     * Other methods
     * =========================================================================
     * */

    public List <R> modifyList(List <T> list, Function <T, R> func) {
        ArrayList <R> res = new ArrayList <>();

        for (T i : list) {
            res.add(func.apply(i));
        }

        return res;
    }

    public R modifyObject(T obj, Function <T, R> func) {
        return func.apply(obj);
    }

}

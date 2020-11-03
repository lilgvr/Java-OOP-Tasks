import ru.gavrilenko.mathematics.block10.Fraction;
import ru.gavrilenko.mathematics.block10.PublicCloneable;

public class Main {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(3,2);

        Fraction f2 = f1.clone();
    }

    public PublicCloneable cloneOrNull(PublicCloneable obj){
        return obj.clone();
    }

    public PublicCloneable[] cloneArr(PublicCloneable ...objs){
        PublicCloneable[] res = new PublicCloneable[objs.length];

        for(int i = 0; i < objs.length; i++){
            res[i] = objs[i].clone();
        }

        return res;
    }

}

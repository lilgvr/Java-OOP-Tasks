package practic.univer;

import ru.gavrilenko.animals.block11.Cat;

public class ScientistCat extends Cat {
    private int countOfMeows = 0;

    public ScientistCat(String name) {
        super(name);
    }

    public void meow() {
        countOfMeows++;
        super.meow();
    }

    public void meow(int n) {
        if (n > 0) countOfMeows += n;
        super.meow(n);
    }

    public int getCountOfMeows() {
        return countOfMeows;
    }
}

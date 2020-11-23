package practic.univer;

import ru.gavrilenko.mathematics.block11.Lengthable;

public class StringL implements Lengthable {
    private String s;

    public StringL(String s) {
        this.s = s;
    }

    public double getLength() {
        char[] arr = s.toCharArray();
        int codeSum = 0;

        for (char i : arr) {
            codeSum += i;
        }

        return codeSum;
    }
}

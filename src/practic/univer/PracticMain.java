package practic.univer;

import ru.gavrilenko.mathematics.block11.Lengthable;
import ru.gavrilenko.mathematics.block11.Line;
import ru.gavrilenko.mathematics.block11.Point;

import static ru.gavrilenko.mathematics.block11.Lengths.getAllLength;

/**
 * <b>Главный класс для практических заданий</b>
 *
 * <ul>
 *     <li>Главный класс для заданий из задачника: {@link ru.Main}</li>
 * </ul>
 *
 * @author Дима
 */

public class PracticMain {
    public static void main(String[] args) {
        StringL str = new StringL("Qwerty");

        Line line = new Line(new Point(1, 2), new Point(5, 6));

        System.out.println(getAllLength(line, str));

    }
}

class StringL implements Lengthable {
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


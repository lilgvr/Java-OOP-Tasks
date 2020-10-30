import ru.gavrilenko.media.block6.Editable;
import ru.gavrilenko.media.block6.RatingAction;
import ru.gavrilenko.media.block6.SafeComment;

public class Main {
    public static void main(String[] args) {
        SafeComment sc = new SafeComment(5);
        System.out.println(sc);
        System.out.println(sc.isEditable());
    }
}

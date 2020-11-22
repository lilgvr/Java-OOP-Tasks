package practic.univer;

public class Gift {
    private String title;

    public Gift(String title) {
        if (title != null && !title.equals(""))
            this.title = title;
    }

    public String toString() {
        return title;
    }
}

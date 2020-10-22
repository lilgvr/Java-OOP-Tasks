package ru.gavrilenko.media.block1;

public class Comment {
    public int rating;
    public String[] text = {
            "Лучше бы уроки сидел учил",
            "А можно поподробнее?",
            "Ха-ха",
            "Зачем же ты так..",
            "Полностью согласен"
    };

    private String comment(int rating){
        if (rating < 0) {
            return text[0];
        } else if (rating < 100 && rating != 0) {
            return text[1];
        } else if (rating < 500 && rating != 0) {
            return text[2];
        } else if (rating < 1000 && rating != 0) {
            return text[3];
        } else {
            return rating >= 1000 ? text[4] : "Ну и как мне это комментировать?";
        }
    }

    public String toString(){
        return "(" + rating + ") " + comment(rating);
    }
}

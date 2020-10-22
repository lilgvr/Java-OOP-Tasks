package ru.gavrilenko.media.block2;

import java.util.ArrayList;

public class Comment {
    private int rating;
    private ArrayList<Comment> coms = new ArrayList<>();
    private String[] a = {
            "Лучше бы уроки сидел учил",
            "А можно поподробнее?",
            "Ха-ха",
            "Зачем же ты так..",
            "Полностью согласен"
    };


    public Comment(int rating){
        this.rating = rating;
    }

    public void addComment(int rating){
        Comment t = new Comment(rating);
        coms.add(t);
    }


    private String comment(int rating){
        if (rating < 0) {
            return a[0];
        } else if (rating < 100 && rating != 0) {
            return a[1];
        } else if (rating < 500 && rating != 0) {
            return a[2];
        } else if (rating < 1000 && rating != 0) {
            return a[3];
        } else {
            return rating >= 1000 ? a[4] : "Ну и как мне это комментировать?";
        }
    }

    public String getText(){
        String lns = "";
        String com = "";
        String res = this.toString() + "\n";

        for(int i = 0; i < coms.size(); i++){
            lns += "--";
            com = lns + coms.get(i) + "\n";
            res += com;
        }

        return res;
    }

    public String toString(){
        return "(" + rating + ") " + comment(rating);
    }
}

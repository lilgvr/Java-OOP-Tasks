package ru.gavrilenko.media.block6;

import java.util.ArrayList;

public class SafePost implements Editable{
    private String title, text;
    private int rating;
    private final String[] tags;
    private ArrayList<SafeComment> comments = new ArrayList<>();
    private boolean isRatingEdited = false, isEditable;

    public SafePost(String title, String text, int rating, String ...tags) {
        this.title = title;
        this.text = text;
        this.rating = rating;
        this.tags = tags;
    }

    public SafeComment getComment(int n){
        return comments.get(n);
    }

    public void addComment(int rating){
        if(comments.size() != 0){
            comments.get(comments.size() - 1).addComment(rating);
        }else{
            comments.add(new SafeComment(rating));
        }
    }

    public String getTitle() {
        return title;
    }

    public void editText(String text){
        if(isRatingEdited || comments.size() != 0) throw new RuntimeException("Изменение текста запрещено");

        this.text = text;
    }

    public void editComment(int newRating, int comNum){
        if(isRatingEdited || comments.size() != 0) throw new RuntimeException("Изменение комментария запрещено");

        if(comNum < 0 || comNum >= comments.size()) throw new IllegalArgumentException();

        comments.set(comNum, new SafeComment(newRating));
    }

    public void editRating(RatingAction ra){
        switch (ra) {
            case decrease -> rating--;
            case increase -> rating++;
        }

        isRatingEdited = true;
    }

    public boolean isEditable(){
        return isEditable;
    }

    public String toString(){
        String tag = "";
        String coms = "";

        for(SafeComment i : comments){
            coms += i.getText() + "\n";
        }

        for(int i = 0; i < tags.length; i++){
            if(i != tags.length - 1){
                tag += tags[i] + ", ";
            }else{
                tag += tags[i];
            }
        }

        return "(" + rating + ") " + title + "\n\n" +
                "тэги: " + tag + "\n\n" +
                text + "\n\n" +
                ((comments.size() != 0)? "Комментарии: \n" + coms : "");
    }
}

package ru.gavrilenko.media.block3;

import ru.gavrilenko.media.block2.Comment;

import java.util.ArrayList;

public class Post {
    private String title, text;
    private int rating;
    private String[] tags;
    private ArrayList<Comment> comments = new ArrayList<>();

    public Post(String title, String text, int rating, String ...tags) {
        this.title = title;
        this.text = text;
        this.rating = rating;
        this.tags = tags;
    }

    public Comment getComment(int n){
        return comments.get(n);
    }

    public void addComment(int rating){
        if(comments.size() != 0){
            comments.get(comments.size() - 1).addComment(rating);
        }else{
            comments.add(new Comment(rating));
        }
    }

    public String toString(){
        String tag = "";
        String coms = "";

        for(Comment i : comments){
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

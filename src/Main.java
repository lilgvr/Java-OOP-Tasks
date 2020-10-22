import gavrilenko.media.block3.Post;

public class Main {
    public static void main(String[] args) {
        Post post = new Post(
                "История транзистора",
                "Дорога к твердотельным переключателям была долгой.",
                10, "IT", "History");

        post.addComment(1);
        post.getComment(0).addComment(0);
        post.getComment(0).addComment(0);

        System.out.println(post);
    }
}

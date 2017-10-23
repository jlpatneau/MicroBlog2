
/**
 * Write a description of class Post3 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Post3
{
    private static int nextPostIndex = 1;
    private String userName;
    private int postIndex;
    private String post;
    private String postLink;

    /**
     * Constructor for objects of class Post3
     */
    public Post3(String userName, String post, String postLink) {
        // initialize instance variables
        this.postIndex = nextPostIndex;
        nextPostIndex++;
        this.userName = userName;
        this.post = post;
        this.postLink = postLink;

    }

    public int getPostIndex() {
        return postIndex;
    }

    public String getPost()  {
        return post;
    }

    public String getPostLink() {
        return postLink;
    }

    public String getPostUserName() {
        return userName;
    }
    public static void setPost(String userId, String post, String link) {
        Post3 newPost = new Post3(userId, post, link);
        
    }
}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Post
{
    private static int nextPostIndex = 1;
    private User user;
    private int postIndex;
    private String post;
    private String postLink;

    /**
     * Constructor for objects of class Post
     */
    public Post(User user, String post, String postLink) {
        // initialize instance variables
        this.postIndex = nextPostIndex;
        nextPostIndex++;
        this.user = user;
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

    public User getPostUser() {
        return user;
    }


    public static void setPost(User user, String post, String link) {
        Post newPost = new Post(user, post, link);
        
    }

    public static void displayLastPost(ArrayList blogPosts, String currentUser) {
        String checkUser = "";
        int lastIndex = 0;
        String lastPost = "";
        String lastPostlink = "";
        Boolean postFound = false;
        if (blogPosts.size() > 0) {
            Iterator iter = blogPosts.iterator();
            while (iter.hasNext()){
                Post post = (Post) iter.next();
                checkUser = post.getPostUser().getUserName();
                if (checkUser.equals(currentUser)) {
                    postFound = true;
                    if(lastIndex < post.getPostIndex()) {
                        lastPost = post.getPost();
                        lastPostlink = post.getPostLink();
                    }
                }
            }
            if (postFound && lastPostlink.isEmpty()) {
                System.out.println("Your last post : " + lastPost );
            } else if (postFound) {
                System.out.println("Your last post : " + lastPost);
                System.out.println("Link: " + lastPostlink);
            } else {
                System.out.println("You do not have any posts yet.");
            }
        } else {
            System.out.println("There are not any posts. ");
        }
    }

    public static void displayPosts(ArrayList blogPosts) {
        System.out.println("Current blog posts");

        if (blogPosts.size() > 0) {
            Iterator iter = blogPosts.iterator();
            while (iter.hasNext()) {
                Post post = (Post) iter.next();
                if (post.getPostLink().isEmpty()){
                    System.out.println(post.getPostUser().getUserName() + " - " + post.getPost());
                }else {
                    System.out.println(post.getPostUser().getUserName() + " - " + post.getPost());
                    System.out.println("Link: " + post.getPostLink());
                }
            }
        } else  {
            System.out.println("There are no posts.");
        }
    }

    public static Post createPost(String currentUser, ArrayList blogUsers) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(currentUser + ", what do you want to post? ");
        String newPost = keyboard.nextLine();
        System.out.print("Post Link? ");
        String newLink = keyboard.nextLine();

        User user = new User();
        Boolean userFound = false;

        if (blogUsers.size() > 0) {
            Iterator iter = blogUsers.iterator();
            while (iter.hasNext() && !userFound){
                User u = (User) iter.next();
                String checkUser = u.getUserName();
                if (checkUser.equals(currentUser)) { //get user obj for current user
                    userFound = true;
                    user = u;
                }
            }
        }
        Post post = new Post(user, newPost, newLink);
        return post;
    }
}

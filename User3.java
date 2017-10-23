import java.util.ArrayList;

public class User3
{
    // instance variables - replace the example below with your own
    private String userId;
    private String userUrl;
    private String realName;
    private String email;

    static ArrayList posts = new ArrayList(); //list of posts

    public User3(String userName, String picture, String realName, String email)   
    {
        // initialise instance variables
        this.userId = userName;
        this.userUrl = picture;
        this.realName = realName;
        this.email = email;
    }

    public String getUserName()
    {
        return userId;
    }

    public String getUserPic()
    {
        return userUrl;
    }

    public String getRealName()
    {
        return realName;
    }

    public String getEmail()
    {
        return email;
    }

    public void add(Post3 p) {
        posts.add(p);
    }

    public static void setUser(String userName, String userPic, String name, String email) {
        User3 newUser = new User3(userName, userPic, name, email);
    }

    public static void printUserPosts(String userName) {
        for (int cnt=0; cnt<posts.size(); cnt++) {
            Post3 p = (Post3) posts.get(cnt);
            System.out.println(p);
        }
    }
}

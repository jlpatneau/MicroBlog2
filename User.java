import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class User
{
    // instance variables - replace the example below with your own
    private static int nextUserIndex = 1;
    private int userIndex;
    private String userName;
    private String userUrl;
    private String realName;
    private String email;

    static ArrayList posts = new ArrayList(); //list of posts

    public User() {

    }

    public User(String userName, String picture, String realName, String email)
    {
        // initialise instance variables
        this.userIndex = nextUserIndex;
        nextUserIndex++;
        this.userName = userName;
        this.userUrl = picture;
        this.realName = realName;
        this.email = email;
    }

    public String getUserName()
    {
        return userName;
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

    public int getUserIndex() {
        return userIndex;
    }

    /*
    public static void setUser(String userName, String userPic, String name, String email) {
        User newUser = new User(userName, userPic, name, email);
    }*/

    public void add(Post p) {
        posts.add(p);
    }

    public static void printUserPosts(String userName) {
        for (int cnt=0; cnt<posts.size(); cnt++) {
            Post p = (Post) posts.get(cnt);
            System.out.println(p);
        }
    }

    public static User createUser() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is the new User ID? ");
        String newUserID = keyboard.nextLine();
        System.out.print("What is the new avatar URL? ");
        String newUrl = keyboard.nextLine();
        System.out.print("What is the new user's real name? ");
        String newName = keyboard.nextLine();
        System.out.print("What is the new user's email? ");
        String newEmail = keyboard.nextLine();

        User newUser = new User(newUserID, newUrl, newName, newEmail);

        return newUser;
    }

    public static void displayUsers(ArrayList blogUsers) {
        System.out.println("Current blog users");
        //int userIndex = 0;
        if (blogUsers.size() > 0) {
            Iterator iter = blogUsers.iterator();
            while (iter.hasNext()) {
                User name = (User) iter.next();
                System.out.println(name.getUserIndex() + " " + name.getUserName() + " - " + name.getRealName());
            }
        } else {
            System.out.println("There are no current blog users");
        }
    }

    public static String changeUsers(ArrayList blogUsers) {
        User.displayUsers(blogUsers);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please choose a new user, by number, from the above list : ");
        int newIndex = keyboard.nextInt();
        boolean validIndex = false;
        String newUser = "";
        if (blogUsers.size() > 0) {
            Iterator iter = blogUsers.iterator();
            while (iter.hasNext() && !validIndex) {
                User user = (User) iter.next();
                if (newIndex == user.getUserIndex()) {
                    validIndex = true;
                    newUser = user.getUserName();
                } else {
                    validIndex = false;
                }
            }
        }
        if (!validIndex) {
            System.out.println("Invalid choice.  Please choose again.");
        }
        return newUser;
    }

}

import java.util.*;

public class Menu3 {

    // instance variables - replace the example below with your own
    static Boolean quit = false;
    private static String currentUser;
    static ArrayList blogUsers = new ArrayList();
    static ArrayList blogPosts = new ArrayList();

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        while (!quit) {
            displayMenu();
            
            int menuChoice = keyboard.nextInt();
            keyboard.skip("\n");
            if(menuChoice == 9) {
                quit = true;
            } else {
                switch (menuChoice) {
                    case 1: //create new user
                    currentUser = createUser();
                    blogUsers.add(currentUser);
                    break;
                    case 2: // become existing user
                    currentUser = changeUsers(blogUsers);
                    break;
                    case 3: // create post as current user
                    createPost(currentUser);
                    break;
                    case 4: // print all posts
                    displayPosts(blogPosts);
                    //printBlog(Post3[]);
                    break;
                    case 5: // print all users
                    displayUsers(blogUsers);
                    //printUsers(User3[]);
                    break;
                    default:
                    System.out.println("Please make a valid choice");
                    break;
                }

            }
        }

    }

    public static String createUser() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is the new User ID? ");
        String newUserID = keyboard.nextLine();
        System.out.print("What is the new avatar URL? ");
        String newUrl = keyboard.nextLine();
        System.out.print("What is the new user's real name? ");
        String newName = keyboard.nextLine();
        System.out.print("What is the new user's email? ");
        String newEmail = keyboard.nextLine();

        User3.setUser(newUserID, newUrl, newName, newEmail);

        return newUserID;
    }

    public static void displayUsers(ArrayList blogUsers) {
        System.out.println("Current blog users");
        if (blogUsers.size() > 0) {
            Iterator iter = blogUsers.iterator();
            while (iter.hasNext()) {
                String name = (String) iter.next();
                System.out.println(name);
            }
        } else {
            System.out.println("There are no current blog users");
        }
    }

    public static String changeUsers(ArrayList blogUsers) {
        displayUsers(blogUsers);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please choose a new user from the above list : ");
        String newUser = keyboard.nextLine();
        //new userid validation
        return newUser;
    }

    public static void displayPosts(ArrayList blogPosts) {
        System.out.println("Current blog posts");

        if (blogPosts.size() > 0) {
            Iterator iter = blogPosts.iterator();
            while (iter.hasNext()) {
                String post = (String) iter.next();
                System.out.println(post);
            }
        } else {
            System.out.println("There are no posts.");
        }
    }

    public static void createPost(String userId) {
        User3.printUserPosts(userId);
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print(userId + ", what do you want to post? ");
        String newPost = keyboard.nextLine();
        System.out.print("Do you have a link? ");
        String newLink = keyboard.nextLine();
        
        Post3.setPost(userId, newPost, newLink);
        blogPosts.add(newPost);
    }
    
    public static void displayMenu() {
        System.out.println("\nMain Menu");
        System.out.println("1. Create a user ");
        System.out.println("2. Become a user ");
        System.out.println("3. Create a post as the current user");
        System.out.println("4. Print all posts");
        System.out.println("5. Print all users");
        System.out.println("9. Quit");
        System.out.print("You are currently userID " + currentUser);
        System.out.print(". What would you like to do? ");
    }
    public static void printBlog(Post3[] blogs)
    {
        System.out.println("Welcome to the Star Wars Blog");
        for (int count = 0; count < blogs.length; count++) {
            System.out.println(blogs[count].getPostIndex() + " - " + blogs[count].getPostUserName() + " - " + 
                blogs[count].getPost() );
            System.out.println(blogs[count].getPostLink() );
            //System.out.println("\n");
        }
    }

    public static void printUsers(User3[] users)
    {
        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
        System.out.println("Blog User Information");
        for (int count = 0; count < users.length; count++) {
            System.out.println("\n" + users[count].getUserPic() + "  " + users[count].getUserName() );
            System.out.println(users[count].getRealName() );
            System.out.println(users[count].getEmail() );
        }
    }
}


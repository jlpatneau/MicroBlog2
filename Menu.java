import java.util.*;

public class Menu {

    // instance variables
    static Boolean quit = false;
    static String currentUser;
    static ArrayList<User> blogUsers = new ArrayList();
    static ArrayList<Post> blogPosts = new ArrayList();


    public static void main(String[] args) {
        //load initial data
        createInitalBlog();
        currentUser = "tman";
        
        Scanner keyboard = new Scanner(System.in);

        while (!quit) {
            displayMenu();
            int menuChoice = 0;
            menuChoice = keyboard.nextInt();
            keyboard.skip("\n");
            if(menuChoice == 9) {
                quit = true;
            } else {
                switch (menuChoice) {
                    case 1: //create new user
                    User newUser = User.createUser();
                    blogUsers.add(newUser);
                    currentUser = newUser.getUserName();
                    break;
                    case 2: // become existing user
                    do {
                        currentUser = User.changeUsers(blogUsers);
                    } while (currentUser.isEmpty());

                    break;
                    case 3: // create post as current user
                        Post.displayLastPost(blogPosts, currentUser);
                        Post post = Post.createPost(currentUser, blogUsers);
                        blogPosts.add(post);

                    break;
                    case 4: // print all posts
                    Post.displayPosts(blogPosts);

                    break;
                    case 5: // print all users
                    User.displayUsers(blogUsers);

                    break;
                    default:
                    System.out.println("Please make a valid choice");
                    break;
                }

            }
        }

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


    public static void createInitalBlog() {

        User user1 = new User("tman", "www.google.com/tman.jpeg","Tim Smith", "tsmith@gmail.com");
        blogUsers.add(user1);
        User user2 = new User("jgirl","www.google.com/jgirl.jpeg",  "Julie Jones", "jjones@gmail.com");
        blogUsers.add(user2);
        User user3 = new User("suzz","www.google.com/suzz.jpeg",  "Suzy Strong", "sstrong@gmail.com");
        blogUsers.add(user3);

        blogPosts.add(new Post(user1, "Anyone got plans for tonight?", ""));
        blogPosts.add(new Post(user2,  "Did you see the new Star Wars - the Last Jedi trailer?", "www.starwars.com"));
        blogPosts.add(new Post(user1, "I did and I can't wait until December", "www.starwars.com/lastjedi"));
        blogPosts.add(new Post(user3, "I hope that new cute critter isn't wookie food.", ""));
        blogPosts.add(new Post(user2, "Do you think Rey is going to the dark side?", ""));

    }

}


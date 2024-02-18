import java.util.*;

//Class for user signup and recommendation process
public class SignUpAndRecommendation {
 // List to store user profiles
 private static List<User> userList = new ArrayList<>();

 // Main method to initiate the program
 public static void main(String[] args) {
     // Initialize the user database
     initializeUserDatabase();

     // Perform user signup and recommendation
     performSignUpAndRecommendation();
 }

 // Method to initialize the user database with sample users
 private static void initializeUserDatabase() {
     // Array of sample users
     User[] users = {
         new User("Alice", 30, "Female", "alice@gmail.com", "Engineer", "ABC Company", "Toronto", Arrays.asList("Reading", "Gardening", "Coding")),
         new User("Bob", 35, "Male", "bob@gmail.com", "Teacher", "123 School", "Vancouver", Arrays.asList("Painting", "Swimming", "Music")),
         new User("Carol", 28, "Female", "carol@gmail.com", "Artist", "XYZ Gallery", "Montreal", Arrays.asList("Painting", "Reading", "Cooking")),
         new User("David", 40, "Male", "david@gmail.com", "Doctor", "City Hospital", "Calgary", Arrays.asList("Swimming", "Gaming", "Movies")),
         new User("Emma", 25, "Female", "emma@gmail.com", "Student", "University XYZ", "Ottawa", Arrays.asList("Dancing", "Movies", "Music")),
         new User("Frank", 45, "Male", "frank@gmail.com", "Chef", "Tasty Restaurant", "Edmonton", Arrays.asList("Cooking", "Baking", "Gardening")),
         new User("Grace", 32, "Female", "grace@gmail.com", "Writer", "Book Publishing Co.", "Winnipeg", Arrays.asList("Reading", "Writing", "Traveling")),
         new User("Henry", 38, "Male", "henry@gmail.com", "Software Engineer", "Tech Innovations Ltd.", "Halifax", Arrays.asList("Coding", "Gaming", "Movies")),
         new User("Isabel", 29, "Female", "isabel@gmail.com", "Dancer", "Dance Academy", "Victoria", Arrays.asList("Dancing", "Singing", "Painting")),
         new User("Jack", 42, "Male", "jack@gmail.com", "Architect", "Urban Designs Inc.", "Quebec City", Arrays.asList("Architecture", "Traveling", "Reading")),
         new User("Katherine", 36, "Female", "katherine@gmail.com", "Lawyer", "Legal Associates", "Saskatoon", Arrays.asList("Reading", "Hiking", "Music")),
         new User("Liam", 31, "Male", "liam@gmail.com", "Entrepreneur", "Tech Startup", "Regina", Arrays.asList("Coding", "Business", "Traveling"))
     };
     // Add sample users to the user list
     userList.addAll(Arrays.asList(users));
 }

 // Method to perform user signup and recommendation
 private static void performSignUpAndRecommendation() {
     Scanner scanner = new Scanner(System.in);

     // Prompt user to enter signup details
     System.out.println("Welcome to the Signup Process!");
     System.out.print("Enter your name: ");
     String name = scanner.nextLine();
     System.out.print("Enter your age: ");
     int age = scanner.nextInt();
     scanner.nextLine(); // Consume newline character
     System.out.print("Enter your gender: ");
     String gender = scanner.nextLine();
     System.out.print("Enter your mode of communication (email | phone #): ");
     String communicationMode = scanner.nextLine();
     System.out.print("Enter your occupation: ");
     String occupation = scanner.nextLine();
     System.out.print("Enter your institution: ");
     String institution = scanner.nextLine();
     System.out.print("Enter your city of living: ");
     String city = scanner.nextLine();

     // Collect user interests
     List<String> interests = collectInterests();

     // Create a new user object
     User newUser = new User(name, age, gender, communicationMode, occupation, institution, city, interests);
     // Add the new user to the user list
     userList.add(newUser);

     // Generate recommendations for the new user
     generateRecommendations(newUser);
 
 // Output the new user list
//System.out.println("Updated User List:");
//printUserList();
}

private static void printUserList() {
for (User user : userList) {
   System.out.println(user);
   
}
}
 // Method to collect user interests
 private static List<String> collectInterests() {
     // Scanner object to collect user input
     Scanner scanner = new Scanner(System.in);
     // List to store user interests
     List<String> interests = new ArrayList<>();

     // List of available interests
     List<String> availableInterests = Arrays.asList(
             "Traveling", "Cooking", "Singing", "Painting",
             "Swimming", "Music", "Reading", "Chilling", "Gardening", "Coding",
             "Gaming", "Movies", "Crocheting", "Dancing", "Skiing", "Fishing",
             "Sports", "Cars", "Makeup", "Biking", "Boxing"
     );

     // Prompt user to enter interests
     System.out.println("Available interests: " + availableInterests);
     System.out.println("Enter your interests (press Enter after each interest, leave blank to finish):");
     String input;
     while (true) {
         input = scanner.nextLine();
         if (input.isEmpty()) {
             break;
         }
         interests.add(input.trim());
     }

     return interests;
 }

 // Method to generate recommendations for a new user
 private static void generateRecommendations(User newUser) {
     // Map to store users grouped by interests
     Map<String, List<User>> interestGroups = new HashMap<>();

     // Group users based on their interests
     for (User user : userList) {
         for (String interest : user.getInterests()) {
             interestGroups.computeIfAbsent(interest, k -> new ArrayList<>()).add(user);
         }
     }

     // Set to store users with similar interests
     Set<User> similarUsers = new HashSet<>();
     // Iterate through new user's interests
     for (String interest : newUser.getInterests()) {
         // Find users with the same interest and add them to the set
         List<User> usersWithInterest = interestGroups.get(interest);
         if (usersWithInterest != null) {
             similarUsers.addAll(usersWithInterest);
         }
     }

     // Remove the new user from the set of similar users
     similarUsers.remove(newUser);

     // Output recommended users with similar interests
     System.out.println("Recommended Users with Similar Interests:");
     for (User user : similarUsers) {
         System.out.println(user);
     }
 }

 // Inner class to represent user data
 static class User {
     // User attributes
     private String name;
     private int age;
     private String gender;
     private String communicationMode;
     private String occupation;
     private String institution;
     private String city;
     private List<String> interests;

     // Constructor to initialize user object
     public User(String name, int age, String gender, String communicationMode, String occupation, String institution, String city, List<String> interests) {
         this.name = name;
         this.age = age;
         this.gender = gender;
         this.communicationMode = communicationMode;
         this.occupation = occupation;
         this.institution = institution;
         this.city = city;
         this.interests = interests;
     }

     // Getter method for user interests
     public List<String> getInterests() {
         return interests;
     }

     // Method to represent user as a string
     @Override
     public String toString() {
         return "Name: " + name +
                 ", Age: " + age +
                 ", Gender: " + gender +
                 ", Communication Mode: " + communicationMode +
                 ", Occupation: " + occupation +
                 ", Institution: " + institution +
                 ", City: " + city;
     }
 }
}

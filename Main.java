import java.util.Scanner;
import java.util.*;
public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        ArrayList<SecurePassword> passwordList = new ArrayList<SecurePassword>();
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Choose an option:");
            System.out.println("1: Create a new username and password for a website");
            System.out.println("2: Search for a password by website");
            System.out.println("3: Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                // Get the website name from the user
                String website = inputWebsite(scanner);
                System.out.println("Website entered: " + website);

                // Get the username from the user
                String username = inputUsername(scanner);
                System.out.println("Username entered: " + username);

                System.out.println("Choose a secure password that meets these requirements:");
                System.out.println("- Is at least 8 characters long");
                System.out.println("- Contains at least one uppercase letter");
                System.out.println("- Contains at least one lowercase letter");
                System.out.println("- Contains at least one numeric digit");
                System.out.println("- Contains at least one of these symbols: ! @ # $ % ^ & * ?");
                System.out.print("\nEnter your secure password: ");
                String password = scanner.nextLine();

                // Creating SecurePassword object
                SecurePassword pwd = new SecurePassword(website, username, password);
                while (!pwd.isSecure()) {
                    System.out.println(pwd.status());
                    System.out.print("Enter a new secure password: ");
                    pwd.setPassword(scanner.nextLine());
                }
                passwordList.add(pwd);
                System.out.println("Password saved successfully!");
                System.out.println(pwd.status());
                System.out.println("Website: " + pwd.getWebsite());
                System.out.println("Username: " + pwd.getUsername());
                System.out.println("Password: " + pwd.getPassword());
            } else if (choice == 2) {
                // Search for a password by website
                System.out.print("Enter the website to search for: ");
                String searchWebsite = scanner.nextLine();
                boolean found = false;
                for (SecurePassword sp : passwordList) {
                    if (sp.getWebsite().equalsIgnoreCase(searchWebsite)) {
                        System.out.println("Website: " + sp.getWebsite());
                        System.out.println("Username: " + sp.getUsername());
                        System.out.println("Password: " + sp.getPassword());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("No password found for the website: " + searchWebsite);
                }
            } else if (choice == 3) {
                continueRunning = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Method to input website name
    public static String inputWebsite(Scanner scanner) {
        System.out.print("Please enter the website: ");
        return scanner.nextLine();
    }

    // Method to input username
    public static String inputUsername(Scanner scanner) {
        System.out.print("Please enter your username: ");
        return scanner.nextLine();
    }
       
}

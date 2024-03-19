import java.util.Scanner;
public class Main {
    Scanner scanner = new Scanner(System.in);

    public void student () {
        String nim;
        scanner.nextLine();
        System.out.print("Enter your NIM :");
        nim = scanner.nextLine();
        if (nim.length() == 15) {
            System.out.println("Successful Login as Student");
        } else {
            System.out.println("User Not Found");
        }
    }

    public void admin() {
        String username = "admin";
        String password = "admin";
        scanner.nextLine();
        System.out.print("Enter your username :");
        username = scanner.nextLine();
        System.out.print("Enter your password :");
        password = scanner.nextLine();
        if (username.equals(password)) {
            System.out.println("Successful Login as Admin");
        }else{
            System.out.println("Admin User Not Found");
        }
    }

    public static void main(String[] args) {
        Main obj = new Main();
        int pilihan;

        System.out.println("Library System");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.println("Choose Option (1-3):");
        pilihan = obj.scanner.nextInt();

        switch (pilihan) {
            case 1:
                obj.student();
                break;
            case 2:
                obj.admin();
                break;
            case 3:
                System.out.println("thank you");
                break;
            default:
                System.out.println("invalid choose");
        }

    }
}
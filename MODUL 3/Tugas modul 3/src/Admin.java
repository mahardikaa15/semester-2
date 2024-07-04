import java.util.Scanner;

public class Admin extends User {

    String adminUsername = "admin";
    String adminPassword = "admin";
    User[] studentList = new User[100];
    int studentCount = 0;



    public Admin(String name, String faculty, String nim, String program) {
        super(name, faculty, nim, program);
    }

    void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        String nim;
        do {
            System.out.print("Masukkan NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM tidak valid. NIM harus memiliki panjang 15 karakter.");
            }
        } while (nim.length() != 15);
        System.out.print("Masukkan fakultas: ");
        String fakultas = scanner.nextLine();
        System.out.print("Masukkan prodi: ");
        String programStudi = scanner.nextLine();

        User newUser = new User(nim, nama, fakultas, programStudi);
        studentList[studentCount] = newUser;
        studentCount++;
    }

    void displayStudents() {
        for (int i = 0; i < studentCount; i++) {
            User user = studentList[i];
            System.out.println(user.name + " (" + user.nim + ") - " + user.faculty + ", " + user.program);
        }
    }
}
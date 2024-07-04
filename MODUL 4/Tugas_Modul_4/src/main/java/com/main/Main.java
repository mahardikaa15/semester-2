import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.time.LocalDate;

public class Main {
    Scanner scan = new Scanner(System.in);
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Book> bookList = new ArrayList<>();
    private String adminUsername = "admin";
    private String adminPassword = "admin";

    public void menu () {
        int choice;
        do {
            System.out.println("====== WELCOME TO LIBRARY SYSTEM=======");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as User");
            System.out.print(" Pilihan anda: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginUser();
                    break;
                default:
                    System.out.println("MASUKAN INPUTAN YANG VALID\n");
            }
        } while(choice != 1 && choice != 3);
    }

    public void loginAdmin() {
        String inputUsn;
        String inputPass;

        do {
            System.out.print("Username: ");
            inputUsn = scan.next();
            System.out.print("Password: ");
            inputPass = scan.next();

            if (!inputUsn.equals(adminUsername) || !inputPass.equals(adminPassword)) {
                System.out.println("Masukkan username dan password yang benar!");
            } else {
                adminMenu();
            }
        } while (!inputUsn.equals(adminUsername) || !inputPass.equals(adminPassword));
    }

    public void loginUser() {
        System.out.print("NIM: ");
        String nim = scan.next();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Login berhasil sebagai user!");
            studentMenu();
        } else {
            System.out.println("NIM tidak ditemukan!");
        }
    }

    public void adminMenu() {
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            System.out.println("======DASHBOARD ADMIN======");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Display Book");
            System.out.println("4. Display Students");
            System.out.println("5. Log Out");
            System.out.println("Pilihan anda: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    inputBook();
                    break;
                case 3:
                    displayBook();
                    break;
                case 4:
                    displayStudents();
                    break;
                case 5:
                    System.out.println("TERIMAKASIH SUDAH MENGGUNAKAN PROGRAM INI");
                    menu();
                    break;
                default:
                    System.err.println();
            }

            if (isLanjutkan) {
                boolean inputValid = false;
                do {
                    System.out.println("Apakah Anda ingin melanjutkan program? (y/n): ");
                    String lanjutkan = scan.next();
                    if (lanjutkan.equalsIgnoreCase("y")) {
                        inputValid = true;
                    } else if (lanjutkan.equalsIgnoreCase("n")) {
                        isLanjutkan = false;
                        System.out.println("TERIMA KASIH SUDAH MENGGUNAKAN PROGRAM INI");
                        inputValid = true;
                    } else {
                        System.out.println("Masukkan inputan yang valid!");
                    }
                } while (!inputValid);
            }
        }
    }

    public void studentMenu() {
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            System.out.println("======DASHBOARD STUDENT======");
            System.out.println("1. Display Information");
            System.out.println("2. Show Borrowed Books");
            System.out.println("3. Display and Choose Books");
            System.out.println("4. Return Books");
            System.out.println("5. Log Out");
            System.out.println("Pilihan anda: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    if (!studentList.isEmpty()) {
                        studentList.get(0).displayInfo();
                    } else {
                        System.out.println("Belum ada data mahasiswa yang tersedia.");
                    }
                    break;
                case 2:
                    showBorrowedBooks();
                    break;
                case 3:
                    choiceBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("TERIMAKASIH SUDAH MENGGUNAKAN PROGRAM INI");
                    menu();
                    break;
                default:
                    System.err.println();
            }

            if (isLanjutkan) {
                boolean inputValid = false;
                do {
                    System.out.println("Apakah Anda ingin melanjutkan program? (y/n): ");
                    String lanjutkan = scan.next();
                    if (lanjutkan.equalsIgnoreCase("y")) {
                        inputValid = true;
                    } else if (lanjutkan.equalsIgnoreCase("n")) {
                        isLanjutkan = false;
                        System.out.println("TERIMA KASIH SUDAH MENGGUNAKAN PROGRAM INI");
                        inputValid = true;
                    } else {
                        System.out.println("Masukkan inputan yang valid!");
                    }
                } while (!inputValid);
            }
        }
    }

    public void choiceBook() {
        displayBook();
        System.out.println("Apakah Anda ingin meminjam buku di atas? (y/n)");
        String answer = scan.next();

        if (answer.equalsIgnoreCase("y")) {
            System.out.print("Masukkan ID buku yang ingin Anda pinjam: ");
            String bookId = scan.next();

            boolean bookFound = false;
            for (Book book : bookList) {
                if (book.getBookId().equals(bookId)) {
                    bookFound = true;
                    if (book.getStock() > 0) {
                        System.out.println("Buku berhasil dipinjam: " + book.getTitle());
                        book.borrowBook(LocalDate.now().plusDays(7)); // Mengatur durasi peminjaman menjadi 7 hari dari hari ini
                        book.setStock(book.getStock() - 1);
                    } else {
                        System.out.println("Maaf, stok buku " + book.getTitle() + " habis.");
                    }
                    break;
                }
            }

            if (!bookFound) {
                System.out.println("Buku dengan ID " + bookId + " tidak ditemukan.");
            }
        }
    }

    public void checkLateReturn(Book book) {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(book.getDuration())) {
            System.out.println("Anda telat mengembalikan buku.");
        } else {
            System.out.println("Terima kasih telah mengembalikan buku tepat waktu.");
        }
    }

    public void showBorrowedBooks() {
        System.out.println("Buku yang sedang dipinjam:");

        boolean found = false;
        for (Book book : bookList) {
            if (book.getDuration() != null) {
                found = true;
                System.out.println("- " + book.getTitle());
            }
        }

        if (!found) {
            System.out.println("Anda belum meminjam buku apapun.");
        }
    }

    public void returnBook() {
        System.out.print("Masukkan ID buku yang ingin Anda kembalikan: ");
        String bookId = scan.next();

        boolean bookFound = false;
        for (Book book : bookList) {
            if (book.getBookId().equals(bookId)) {
                bookFound = true;
                if (book.getDuration() != null) {
                    checkLateReturn(book);
                    book.setStock(book.getStock() + 1);
                } else {
                    System.out.println("Error: Buku belum dipinjam.");
                }
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Buku dengan ID " + bookId + " tidak ditemukan.");
        }
    }

    public void addStudent() {
        scan.nextLine();
        System.out.println("Nama Mahasiswa:");
        String name = scan.nextLine();

        String nim;

        do {
            System.out.println("NIM Mahasiswa: ");
            nim = scan.nextLine();

            if (nim.length() != 15) {
                System.out.println("Inputan NIM tidak valid, NIM harus memiliki panjang 15 digit!");
            }
        } while (nim.length() != 15);

        System.out.println("Fakultas Mahasiswa: ");
        String faculty = scan.nextLine();

        System.out.println("Program Studi Mahasiswa: ");
        String major = scan.nextLine();

        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setNim(nim);
        newStudent.setFaculty(faculty);
        newStudent.setMajor(major);

        studentList.add(newStudent);
        System.out.println("DATA BERHASIL DITAMBAHKAN!");
    }

    String generateId() {
        String uniqueID = UUID.randomUUID().toString();
        String id = uniqueID.replaceAll("-", "").toLowerCase();
        return String.format("%s-%s-%s", id.substring(0, 4), id.substring(4, 8), id.substring(8, 12));
    }


    public void inputBook() {
        int bookCount = 0;
        System.out.println("Masukan kategori buku yang ingin ditambahkan : ");
        System.out.println("1. History Book ");
        System.out.println("2. Story Book");
        System.out.println("3. Text Book");
        System.out.print("Pilihan anda: ");
        int option = scan.nextInt();
        scan.nextLine();

        System.out.print("Masukkan judul: ");
        String title = scan.nextLine();
        System.out.print("Masukkan penulis: ");
        String author = scan.nextLine();
        System.out.print("Masukkan stok: ");
        int stock = scan.nextInt();

        String id = generateId();

        switch (option){
            case 1:
                HistoryBook historyBook = new HistoryBook(id, title, author, stock, "History");
                bookList.add(historyBook);
                break;
            case 2:
                StoryBook storyBook = new StoryBook(id, title, author, stock, "Story");
                bookList.add(storyBook);
                break;
            case 3:
                TextBook textBook = new TextBook(id, title, author, stock, "Text");
                bookList.add(textBook);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }


    public void displayBook() {
        System.out.println("==============================================================================================================");
        System.out.printf("| %-14s | %-30s | %-20s | %-20s | %-10s |\n", "ID", "Judul", "Penulis", "Kategori", "Stok");
        System.out.println("==============================================================================================================");
        for (Book book : bookList) {
            System.out.printf("| %-10s | %-30s | %-20s | %-20s | %-10d |\n",
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getCategory(),
                    book.getStock());
        }
        System.out.println("==============================================================================================================");
    }


    public void displayStudents() {
        System.out.println("=======================================================================================");
        System.out.printf("| %-20s | %-15s | %-20s | %-20s |\n", "Nama", "NIM", "Fakultas", "Program Studi");
        System.out.println("=======================================================================================");
        for (Student student : studentList) {
            System.out.printf("| %-20s | %-15s | %-20s | %-20s |\n",
                    student.getName(),
                    student.getNim(),
                    student.getFaculty(),
                    student.getMajor());
        }
        System.out.println("========================================================================================");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
        main.scan.close();
    }
}

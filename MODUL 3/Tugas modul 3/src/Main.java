import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        LibrarySystem librarySystem = new LibrarySystem();
        librarySystem.startLibrarySystem(students, books, scanner);
    }

    static class LibrarySystem {
        public void startLibrarySystem(ArrayList<Student> students, ArrayList<Book> books, Scanner scanner) {
            while (true) {
                System.out.println("===== Library System =====");
                System.out.println("1. Login sebagai Student");
                System.out.println("2. Login sebagai Admin");
                System.out.println("3. Keluar");
                System.out.print("Pilih opsi (1-3): ");
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        loginAsStudent(students, books, scanner);
                        break;
                    case 2:
                        loginAsAdmin(students, books, scanner);
                        break;
                    case 3:
                        System.out.println("Terima kasih. Keluar dari program.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Input tidak valid. Silakan coba lagi.");
                }
            }
        }

        public void loginAsStudent(ArrayList<Student> students, ArrayList<Book> books, Scanner scanner) {
            System.out.println("===== Student Menu ====");
            System.out.print("Masukkan NIM Anda (masukkan 0 untuk kembali): ");
            String nim = scanner.next();

            if (nim.equals("0")) {
                System.out.println("Kembali ke menu utama");
                return;
            }

            Student student = findStudentByNim(students, nim);

            if (student == null) {
                System.out.println("Mahasiswa tidak ditemukan. Kembali ke menu utama");
                return;
            }

            while (true) {
                System.out.println("\n===== Student Menu ====");
                System.out.println("1. Buku Terpinjam");
                System.out.println("2. Pinjam Buku");
                System.out.println("3. Keluar");
                System.out.print("Pilih opsi (1-3): ");
                int userInput = scanner.nextInt();

                switch (userInput) {
                    case 1:
                        student.showBorrowedBooks();
                        break;
                    case 2:
                        student.borrowBook(books, scanner);
                        break;
                    case 3:
                        System.out.println("Keluar dari akun mahasiswa");
                        return;
                    default:
                        System.out.println("Input tidak valid. Silakan coba lagi.");
                        scanner.nextLine();
                }
            }
        }

        public Student findStudentByNim(ArrayList<Student> students, String nim) {
            for (Student s : students) {
                if (s.getNim().equals(nim)) {
                    return s;
                }
            }
            return null;
        }

        public void loginAsAdmin(ArrayList<Student> students, ArrayList<Book> books, Scanner scanner) {
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa Terdaftar");
            System.out.println("3. Input Buku");
            System.out.println("4. Tampilkan Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi (1-5): ");
            int userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    addStudent(students, scanner);
                    break;
                case 2:
                    displayStudents(students);
                    break;
                case 3:
                    inputBook(books, scanner);
                    break;
                case 4:
                    displayBooks(books);
                    break;
                case 5:
                    System.out.println("Keluar dari akun admin");
                    break;
                default:
                    System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }

        public void addStudent(ArrayList<Student> students, Scanner scanner) {
            System.out.print("Masukkan nama mahasiswa: ");
            String name = scanner.next();
            System.out.print("Masukkan fakultas mahasiswa: ");
            String faculty = scanner.next();
            System.out.print("Masukkan NIM mahasiswa: ");
            String nim = scanner.next();
            System.out.print("Masukkan program studi mahasiswa: ");
            String program = scanner.next();

            students.add(new Student(name, faculty, nim, program));
            System.out.println("Mahasiswa berhasil ditambahkan!");
        }

        public void displayStudents(ArrayList<Student> students) {
            System.out.println("\n===== Mahasiswa Terdaftar =====");
            System.out.printf("%-20s %-20s %-15s %-20s\n", "Nama", "Fakultas", "NIM", "Program Studi");
            for (Student student : students) {
                System.out.printf("%-20s %-20s %-15s %-20s\n", student.getName(), student.getFaculty(), student.getNim(),
                        student.getProgram());
            }
        }

        public void inputBook(ArrayList<Book> books, Scanner scanner) {
            System.out.println("Pilih jenis buku:");
            System.out.println("1. History Book");
            System.out.println("2. Story Book");
            System.out.println("3. Text Book");
            System.out.print("Pilih opsi (1-3): ");
            int option = scanner.nextInt();

            String title, author, id;
            int stock, daysToBorrow;

            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Tambahkan id buku:");
                    id = scanner.nextLine();
                    System.out.print("Masukkan judul History Book: ");
                    title = scanner.nextLine();
                    System.out.print("Masukkan penulis History Book: ");
                    author = scanner.nextLine();
                    System.out.print("Masukkan stok History Book: ");
                    stock = scanner.nextInt();
                    System.out.print("Masukkan durasi peminjaman: ");
                    daysToBorrow = scanner.nextInt();
                    books.add(new HistoryBook(id, title, author, "History", stock, daysToBorrow));
                    System.out.println("History Book berhasil ditambahkan!");
                    break;
                case 2:
                    System.out.print("Tambahkan id buku:");
                    id = scanner.nextLine();
                    System.out.print("Masukkan judul Story Book: ");
                    title = scanner.nextLine();
                    System.out.print("Masukkan penulis Story Book: ");
                    author = scanner.nextLine();
                    System.out.print("Masukkan stok Story Book: ");
                    stock = scanner.nextInt();
                    System.out.print("Masukkan durasi peminjaman: "); //
                    daysToBorrow = scanner.nextInt();
                    books.add(new StoryBook(id, title, author, "Story", stock, daysToBorrow));
                    System.out.println("Story Book berhasil ditambahkan!");
                    break;
                case 3:
                    System.out.print("Tambahkan id buku:");
                    id = scanner.nextLine();
                    System.out.print("Masukkan judul Text Book: ");
                    title = scanner.nextLine();
                    System.out.print("Masukkan penulis Text Book: ");
                    author = scanner.nextLine();
                    System.out.print("Masukkan stok Text Book: ");
                    stock = scanner.nextInt();
                    System.out.print("Masukkan durasi peminjaman: ");
                    daysToBorrow = scanner.nextInt();
                    books.add(new TextBook(id, title, author, "Text", stock, daysToBorrow)); //
                    System.out.println("Text Book berhasil ditambahkan!");
                    break;
                default:
                    System.out.println("Opsi tidak valid.");
            }
        }

        public void displayBooks(ArrayList<Book> books) {
            System.out.println("\n===== Daftar Buku =====");
            System.out.printf("%-20s %-20s %-20s %-10s\n", "ID", "Judul", "Penulis", "Stok");
            for (Book book : books) {
                System.out.printf("%-20s %-20s %-20s %-10d\n", book.getBookId(), book.getJudul(), book.getPenulis(),
                        book.getJumlah());
            }
        }
    }
}
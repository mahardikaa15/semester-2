import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{
    String name;
    String faculty;
    String nim;
    String programStudi;

    private static ArrayList<Book> borrowedBooks = new ArrayList<>();


    public Student (String name, String faculty, String nim, String programStudi){
        super(name, faculty, nim, programStudi);
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.programStudi = programStudi;
    }

    public static void borrowBook(ArrayList<Book> books, Scanner scanner) {
        System.out.print("Masukkan ID buku yang ingin dipinjam: ");
        String id = scanner.next();

        if (id.isEmpty()) {
            System.out.println("ID buku tidak boleh kosong. Kembali ke menu mahasiswa...");
            return;
        }

        Book book = null;
        for (Book b : books) {
            if (b.getBookId().equals(id)) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Buку tidak ditemukan. Kembali ke menu mahasiswa");
            return;
        }

        if (book.getJumlah() > 0) {            System.out.print("Berapa lama buku akan dipinjam? (maksimal 15 hari)\nInput lama (hari): ");
            int daysToBorrow = scanner.nextInt();
            if (daysToBorrow > 0 && daysToBorrow <= 14) {
                borrowedBooks.add(book);
                book.setJumlah(book.getJumlah() - 1);
                book.setDaysToBorrow(daysToBorrow); // Set durasi peminjaman
                System.out.println("Buku berhasil dipinjam!");
                System.out.println("Harap kembalikan buku dalam " + daysToBorrow + " hari.");
            } else {
                System.out.println("Lama peminjaman tidak valid. Kembali ke menu mahasiswa...");
            }
        } else {
            System.out.println("Maaf, stok buku habis.");
        }
    }

    public String getName(){
        return name;
    }
    public String getFaculty(){
        return faculty;
    }
    public String getNim (){
        return nim;
    }
    public String getProgramStudi(){
        return programStudi;
    }
    public void displayInfo(){
        System.out.println("Student name : " + name);
        System.out.println("Student NIM : " + nim);
        System.out.println("Student faculty : " + faculty);
        System.out.println("Student Program Studi : " + programStudi);
    }
    public void showBorrowedBooks(){

        if (borrowedBooks.isEmpty()) {
            System.out.println("Anda belum meminjam buku apapun.");
            return;
        }
        System.out.println("\n===== Buku Terpinjam =====");
        System.out.printf("%-20s %-20s %-20s %-10s %-10s\n", "ID", "Judul", "Penulis", "Stok", "Durasi");
        for (Book book : borrowedBooks) {
            System.out.printf("%-20s %-20s %-20s %-10d %-10d\n", book.getBookId(), book.getJudul(), book.getPenulis(), book.getJumlah(), book.getDaysToBorrow());
        }

    }
}
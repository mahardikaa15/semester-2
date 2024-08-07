import java.time.LocalDate;
public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private int stock;
    private LocalDate duration;

    public Book(String bookId, String title, String author, String category, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    public void setBookId (String bookId) {
        this.bookId = bookId;
    }

    public String getBookId (){
        return bookId;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle () {
        return title;
    }

    public void setAuthor (String author) {
        this.author = author;
    }

    public String getAuthor () {
        return author;
    }

    public void setStock (int stock) {
        this.stock = stock;
    }

    public int getStock () {
        return stock;
    }

    public void setCategory () {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDuration () {
        return duration;
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Stock: " + stock);
        System.out.println("Category: " + category);
    }

    public void borrowBook(LocalDate borrowDate) {
        this.duration = borrowDate.plusDays(7); // Peminjaman selama 7 hari dari tanggal peminjaman
    }
}

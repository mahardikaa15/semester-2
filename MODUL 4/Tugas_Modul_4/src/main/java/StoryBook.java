public class StoryBook extends Book {
    private String category;
    public StoryBook (String bookId, String title, String author, int stock, String category) {
        super(bookId, title, author, category, stock);
        this.category = category;
    }

    public void setCategory (String category) {
        this.category = category;
    }

    public String getCategory () {
        return category;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Category: " + category);
    }
}

public class Book {
    String id;
    String judul;
    String penulis;
    String kategori;
    int daysToBorrow;
    int jumlah;

    public Book (String id, String judul, String penulis,String kategori, int jumlah, int daysToBorrow){
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.jumlah = jumlah;
        this.daysToBorrow = daysToBorrow;

    }
    public String getBookId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }
    public String getKategori(){
        return kategori;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int stock) {
        this.jumlah = stock;
    }
    public int getDaysToBorrow() {

        return daysToBorrow;
    }

    public void setDaysToBorrow(int daysToBorrow) {

        this.daysToBorrow = daysToBorrow;
    }

}
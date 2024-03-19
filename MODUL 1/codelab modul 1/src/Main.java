import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nama;
        String jeniskelamin;
        String tanggallahir;
        Scanner input = new Scanner(System.in);
        System.out.println("\n//input\n");

        System.out.print("nama : ");
        nama = input.nextLine();
        System.out.print("jeniskelamin (P/L): ");
        jeniskelamin = input.nextLine();
        System.out.print("tanggal lahir (YYYY-MM-DD): ");
        tanggallahir = input.nextLine();

        LocalDate tanggallahirDate = LocalDate.parse(tanggallahir);
        LocalDate tanggalsekarang = LocalDate.now();
        Period selisih = Period.between(tanggallahirDate, tanggalsekarang);
        int umurtahun = selisih.getYears();
        int umurbulan = selisih.getMonths();

        System.out.println("\n//output");

        System.out.println("\nData Diri:");
        System.out.println("nama: " + nama);
        System.out.println("jenis kelamin: " + jeniskelamin);
        System.out.println("umur: " + umurtahun + " tahun " + umurbulan + " bulan");

        input.close();
    }
}
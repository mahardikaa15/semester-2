import java.util.Scanner;
public class Balok extends bangunruang {
    Balok(String name) {
        super(name);
    }
    private double panjang, lebar, tinggi;
    @Override
    public  void inputNilai() {
        super.inputNilai();
        Scanner inputuser = new Scanner(System.in);
        System.out.print("panjang: ");
        panjang = inputuser.nextDouble();
        System.out.print("lebar: ");
        lebar = inputuser.nextDouble();
        System.out.print("tinggi: ");
        tinggi = inputuser.nextDouble();
    }
    @Override
    public void luasPermukaan() {
        double hasil = 2 *(panjang * lebar + panjang * tinggi + lebar * tinggi);
        super.luasPermukaan();
        System.out.println("Hasil luas permukaan: " + hasil);
    }
    @Override
    public void volume() {
        double hasil = panjang * lebar * tinggi;
        super.volume();
        System.out.println("Hasil volume: ");
    }
}
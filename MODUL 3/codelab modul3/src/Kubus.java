import java.util.Scanner;
public class Kubus extends bangunruang{
    Kubus(String name){
        super(name);
    }
    Scanner scanner = new Scanner(System.in);
    private double sisi;
    @Override
    public void inputNilai(){
        super.inputNilai();
        System.out.print("Input sisi: ");
        sisi = scanner.nextInt();
    }
    @Override
    public void luasPermukaan(){
        double hasil = 6 * sisi * sisi;
        super.luasPermukaan();
        System.out.print("Hasil luas permukaan: " + hasil);
    }
    @Override
    public void volume(){
        double hasil = Math.pow(sisi, 3);
        super.volume();
        System.out.print("Hasil volume: " + hasil);
    }
}
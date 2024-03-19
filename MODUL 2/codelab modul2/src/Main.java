import java.util.Scanner;

public class Main {
    public static  void main(String[] args){
        Mahasiswa mahasiswa = new Mahasiswa();
        Scanner input = new Scanner(System.in);
        int pilihan;
        int ulang = 0;
        do {
            System.out.print("\n1. Tambah data Mahasiswa \n2. Tampilkan data Mahasiswan \n3. Keluar\n");
            System.out.print("Pilihan anda: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    mahasiswa.inputdata();
                    break;

                case 2:
                    System.out.print("Data mahasiswa\n");
                    System.out.println(Mahasiswa.tampiluniversitas());
                    System.out.println(mahasiswa.tampildatamahasiswa());
                    break;

                case 3:
                    ulang= 1;
                    break;


            }
        } while (ulang == 0);
    }
}


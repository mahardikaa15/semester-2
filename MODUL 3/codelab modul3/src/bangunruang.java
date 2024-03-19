public class bangunruang {
    private String name;
    bangunruang(String name){
        this.name = name;
    }
    public void inputNilai(){
        System.out.println("Input nilai");
    }
    public void luasPermukaan(){
        System.out.println("Menghitung luas permukaan bangun ruang ");
    }
    public void volume(){
        System.out.println("Menghitung volume bangunn");
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
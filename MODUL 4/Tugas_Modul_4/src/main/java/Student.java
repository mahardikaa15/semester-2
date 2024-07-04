public class Student {
    private String name;
    private String faculty;
    private String nim;
    private String major;

    public Student() {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.major = major;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setNim (String nim) {
        this.nim = nim;
    }

    public String getNim () {
        return nim;
    }

    public void setMajor (String major) {
        this.major = major;
    }

    public String getMajor () {
        return major;
    }

    public void displayInfo () {
        System.out.println("Nama: " + name);
        System.out.println("Fakultas: " + faculty);
        System.out.println("NIM: " + nim);
        System.out.println("Program Study: " + major);
    }
}

package _manager_school;

public class Student extends Person{
    private String subject;
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Student() {
    }
    public Student(String subject) {
        super(subject);
        this.subject = subject;
    }

    public Student(String name, int age, String address, String subject) {
        // super gọi constructor từ cha
        super(name, age, address);
        this.subject = subject;
    }
    public Student(String name, int age, String address) {
        super(name, age, address);
    }
//    @Override
//    public void goToBy() {
//        System.out.println(" Bằng xe máy");
//    }

    // method overloading
    public void registerSubject(String sb){
        System.out.println("học môn: "+sb);
    }
    // method overloading
    public void registerSubject(){
        System.out.println("dang ky");
    }
    // method overloading
    public int registerSubject(String sb1,String sb2){
        System.out.println("học môn: "+sb1+sb2);
        return 1;
    }

    @Override
    public String toString() {
        return "Sinh viên{" +
                "subject='" + subject + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + addr + '\'' +
                '}';
    }
}

package 변수.access;

public class Parents {
    public String motherName;
    public String fatherName;

    public Parents(String motherName, String fatherName) {
        this.motherName = motherName;
        this.fatherName = fatherName;
    }

    void callParentsName() {
        System.out.println(motherName);
        System.out.println(fatherName);
    }
}

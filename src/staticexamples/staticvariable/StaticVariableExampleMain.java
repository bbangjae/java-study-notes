package staticexamples.staticvariable;

public class StaticVariableExampleMain {
    public static void main(String[] args) {
        Student byun = new Student("byun", 13);
        Student jae = new Student("jae ", 15);

        Student.showStudentCount(); // 2
    }
}

class Student {
    private String name;
    private int age;
    private static int studentCount; // static 변수

    Student (String name, int age) {
        this.name = name;
        this.age = age;
        studentCount++; // static 변수를 통해 객체의 수를 셀 수 있다.
    }

    static void showStudentCount() {
        System.out.println("총 학생 수: " + studentCount);
    }
}

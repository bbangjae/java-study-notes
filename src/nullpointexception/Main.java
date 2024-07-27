package nullpointexception;

public class Main {
    public static void main(String[] args) {

        Grades grades = null;
        System.out.println(grades);

        // NullPointerException 발생
        // System.out.println(grades.korean);

        Student jae = new Student("jae", null);
        System.out.println(jae.name);
        System.out.println(jae.grades);

        // NullPointerException 발생
        // System.out.println(jae.grades.korean);

        // NullPointerException 발생
        // System.out.println(jae.grades.getKorean());
    }
}

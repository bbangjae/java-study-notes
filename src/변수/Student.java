package 변수;

import 변수.access.Parents;

class Student {
    String name;
    Grades grades;
    Parents parents;

    Student(String name, String motherName, String fatherName) {
        this.name = name;
        parents = new Parents(motherName, fatherName);
    }

    void callName() {
        System.out.println(name);
        System.out.println(grades);
        System.out.println(parents.motherName);
        System.out.println(parents.fatherName);

//        default (package-private) 접근 제어자 오류 발생
//        parents.callParentsName();
    }
}

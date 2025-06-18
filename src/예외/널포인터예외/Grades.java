package 예외.널포인터예외;

class Grades {
    int korean;
    int math;

    Grades(int korean, int math) {
        this.korean = korean;
        this.math = math;
    }

    int getKorean() {
        return korean;
    }

    int getMath() {
        return math;
    }
}

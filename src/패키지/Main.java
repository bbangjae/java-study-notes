package 패키지;

import 패키지.free.User;

public class Main {
    public static void main(String[] args) {

        User jae = new User("jae");
        패키지.premium.User young = new 패키지.premium.User("young", "jae");
        패키지.normal.User bang = new 패키지.normal.User("bang", "zero");

        System.out.println(jae.name);
        System.out.println(young.name);
        System.out.println(bang.name);
    }
}
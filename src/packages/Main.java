package packages;

import packages.free.User;

public class Main {
    public static void main(String[] args) {

        User jae = new User("jae");
        packages.premium.User young = new packages.premium.User("young", "jae");
        packages.normal.User bang = new packages.normal.User("bang", "zero");

        System.out.println(jae.name);
        System.out.println(young.name);
        System.out.println(bang.name);
    }
}
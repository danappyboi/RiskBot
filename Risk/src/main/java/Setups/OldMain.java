package Setups;

import java.util.Scanner;

public class OldMain {

    static Scanner scan = new Scanner(System.in);
    public static void main(String [] args) {
        String daddy = scan.nextLine();
        String dad = daddy.substring(0, 5);
        System.out.println(dad);
        if (dad.equals("!play")) {
            System.out.println("gotcha");
        }
    }
}

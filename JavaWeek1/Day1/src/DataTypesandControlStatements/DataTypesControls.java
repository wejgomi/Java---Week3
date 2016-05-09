package DataTypesandControlStatements;

import java.io.Console;
import java.util.Scanner;

public class DataTypesControls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input: ");
        char input = scan.next().charAt(0);
        System.out.println(((Character.isLetter(input) == true || Character.isDigit(input) == true) ? "The character is  " : "No such letter or digit!") + ((Character.isLetter(input) == true) ? "a Number" : "an Integer"));
    }
}

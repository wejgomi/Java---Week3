package DataTypesandControlStatements;

import java.util.Scanner;

public class NestedLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = scan.nextInt();

        for (int i = 0; i < input; i++) {
            for(int k = 0; k < input-i; k++) { System.out.print(" ");}
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}
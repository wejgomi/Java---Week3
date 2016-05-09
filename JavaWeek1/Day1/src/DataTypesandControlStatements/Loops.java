package DataTypesandControlStatements;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Boolean i = null;
        do{
            System.out.print((i == null) ? "Enter a number: " : "Enter another: ");
            int input = scan.nextInt();
            if(input == 20) {
                System.out.print("That's it !");
                i=true;
                break;
            }
            i=false;
        }while(i!=true);
    }
}
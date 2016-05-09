import java.util.Random;
import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int bank = random.nextInt(300) + 1;
        int money;

        while(bank != 0) {
            System.out.println("Amount in the bank: " + bank);
            System.out.print("How much to bet: ");
            money = scan.nextInt();
            System.out.print("Place the bet(2-12): ");
            if(scan.nextInt() == (random.nextInt(9) + 1)+(random.nextInt(9) + 1)) {
                bank += (money*3);
                System.out.println("We have a winner!");
            }
            else { bank -= money; System.out.println((bank > 0) ? "Tough luck, try again!" : "You've gone bankrupt!"); }
        }
    }
}

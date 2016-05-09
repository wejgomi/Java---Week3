package DataTypesandControlStatements;

import java.text.MessageFormat;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int[] input = new int[7];
        int[] winner = new int[7];
        for (int i = 0; i < input.length; i++) {
            System.out.print(MessageFormat.format("Enter the {0}st number: ", i + 1));
            winner[i] = random.nextInt(9) + 1;
            input[i] = scan.nextInt();
        }
        System.out.println(DrawTheLottery(input,winner));
        System.out.println("Winning numbers were: " + winner.toString());
    }

    public static String DrawTheLottery(int[] input, int[] winner) {
        String answer = "Matching numbers are: ";
        for(int i : input) {
            for(int j : winner) {
                if(i == j && !answer.contains(String.valueOf(i))) {
                    answer += i + " ";
                }
            }
        }
        return answer;
    }
}
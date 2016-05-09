import java.util.Scanner;

public class CreditCardVerification {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the 16-digit card number: ");
        Long cardno = scan.nextLong();
        String s = (Checkno(cardno) == 0) ? "valid" : "invalid";
        System.out.println("The card is " + s);
    }

    public static int Checkno(Long cardno) {
        String cardstring = cardno.toString();
        int j = 0;
        int k = 0;
        for(int i = 14; i > 0; i--) {
            String temp = String.valueOf(cardstring.charAt(i) * 2);
            j += (temp.length() > 1) ? Character.getNumericValue(temp.charAt(0)) + Character.getNumericValue(temp.charAt(1)) : temp.charAt(i) * 2;
            k += Character.getNumericValue(cardstring.charAt(i+1));
        }
        return ((j+k) % 10);
    }
}

package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        String answer = "";
        String input;
        int number;
        System.out.print("Which exercise((F)irstLast,(S)ameFirstorLast, (C)ommonEnd, (M)axEnd3, (H)as23,  S(a)meFirstLast, (B)igDiff, S(u)m13): ");
        String type = scan.next().toLowerCase();

        do {
            System.out.print("Enter the elements of the array: ");
            input = scan.next();
            number = Integer.parseInt(input);
            if (!input.isEmpty()) {
                a.add(number);
            } else {
                break;
            }
        }while(!input.isEmpty());

        switch (type) {
            case "f":
                answer = FirstLast6(a);
                break;
            case "s":
                answer = SameFirstLast(a);
                break;
            case "c":
                do {
                    System.out.print("Enter the elements of the second array: ");
                    input = scan.next();
                    number = Integer.parseInt(input);
                    if(input != "") { b.add(number); }
                }while(input.isEmpty());
                answer = CommonEnd(a,b);
                break;
            case "m":
                answer = MaxEnd3(a);
                break;
            case "h":
                answer = Has23(a);
                break;
            case "a":
                answer = SameFirstLast2(a);
                break;
            case "b":
                answer = BigDiff(a);
                break;
        }
        //System.out.println(((answer > 1) ? "Exists " : "Not Found!") + ((answer > 2) ? "for both Array 1 and " : ((answer > 5) ? "3" : "2")));
        System.out.println(answer);
    }

    public static String FirstLast6(ArrayList<Integer> a) {
        String answer = "Not Found!";
        for(int i = 0; i < a.size(); i++) {
            if ((i == 0 || i == (a.size()-1)) && a.indexOf(i) == 6) {
                answer="Exists!";
            }
        }
        return answer;
    }

    public static String SameFirstLast(ArrayList<Integer> a) {
        String answer = "false";
        if (a.size() > 0) { answer =  (a.indexOf(0) == a.indexOf(a.size()) ? "true" : "false"); };
        return answer;
    }

    public static String CommonEnd(ArrayList<Integer> a, ArrayList<Integer> b) {
        String answer = "false";
        if (a.size() > 0) { answer = (a.indexOf(0) == b.indexOf(0) || a.indexOf(a.size()) == b.indexOf(a.size())) ? "true" : "false"; }
        return answer;
    }

    public static String MaxEnd3(ArrayList<Integer> a) {
        String answer = "false";
        if (a.size() > 0) { for(int c = 0; c < a.size(); c++) { a.set(c,(a.indexOf(a.size()) > a.indexOf(0)) ? a.indexOf(a.size()) : a.indexOf(a.size())); } }
        answer = String.valueOf(a);
        return answer;
    }

    public static String Has23(ArrayList<Integer> a) {
        String answer = "false";
        if (a.size() == 2) { for(int i : a) { if (i == 3 || i == 2) { answer = "true"; }  } };
        return answer;
    }

    public static String SameFirstLast2(ArrayList<Integer> a) {
        String answer = "false";
        if (a.size() > 0) { for(int i : a) { if (i % 2 == 0) { answer = "true"; }  } };
        return answer;
    }

    public static String BigDiff(ArrayList<Integer> a) {
        int c = 0;
        for (int b = 0; b < a.size(); b++) {
            c = (b == 0) ? Math.min(a.indexOf(b), a.indexOf(b+1)): Math.min(c, a.indexOf(b+1));
        }
        return String.valueOf(c);
    }

    public static String Sum13(ArrayList<Integer> a) {
        int c = 0;
        for (int b : a) {
            if(b == 13) { break; }
            c += b;
        }
        return String.valueOf(c);
    }

    public static String Sum67(ArrayList<Integer> a) {
        int c = 0;
        for (int b = 0; b < a.size(); b++) {
            if (a.indexOf(b) == 6) {
                while (a.indexOf(b) != 7) {
                    b++;
                }
            }
            c += a.indexOf(b);
        }
        return String.valueOf(c);
    }

    public static String Has22(ArrayList<Integer> a) {
        String answer = "false";
        int b = 0;
        for (int i : a) {
            if (i == 2) { b++; if (b > 2) { answer = "true"; } }
        }
        return answer;
    }
}

package AddressBook;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Registration {

    // define a array of person or Arraylist
    // private person[]people = new people[150];


    // ArrayList
    private final ArrayList<person> people2 = new ArrayList<>();
    //person Laure = new person("Laure", "Guery", 28, 1.74, true);


    // Create a buffer reader

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // method to register
    public void registerUser() {
        Scanner kb = new Scanner(System.in);
        person p = new person();
        //ask the name

        System.out.print("Enter the first name:");
        String fn = kb.nextLine();

        System.out.print("Enter the last name:");
        String ln = kb.nextLine();

        System.out.print("Enter your age:");
        int age = kb.nextInt();
        p.setAge(age);

        System.out.print("Enter your gender: (M or F");
        char gender = kb.next().charAt(0);
        p.setGender (gender);

        System.out.print("Enter you height:");
        Double height = Double.parseDouble(kb.nextLine());
        p.setHeight(height);

        System.out.print("Are you a smoker:");
        boolean smoker = kb.nextBoolean();
        p.setSmoker(smoker);

        p.setName(fn, ln, age,gender, height, smoker);

        people2.add(p);
    }


    public ArrayList<person> generateSampleData() {
        return people2;
    }
}

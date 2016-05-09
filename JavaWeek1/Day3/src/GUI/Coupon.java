package GUI;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Coupon {
    Scanner scan;
    private String desc;
    private double price;

    public Coupon(String desc, double price) {
        this.price = price;
        this.desc = desc;
    }

    public void setValue(double Value) {
        price=Value;
    }
    public double getValue() {
        return price;
    }

    public void setDesc(String Value) {
        desc=Value;
    }
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString(){
        return "Coupon{" + "decription" + desc + '\'' + " value=£" + price + '}';
    }

    public void LoadInfoFromFile() {
        scan = new Scanner(getClass().getResourceAsStream("input.txt"));
    }

    public Scanner getFileReader() {
        return scan;
    }

    public void SaveToFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        PrintWriter pw = new PrintWriter(file);
        pw.println("Description: " + getDesc());
        pw.println("Price: " + getValue());
        pw.close();
    }
}

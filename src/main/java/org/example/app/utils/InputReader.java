package org.example.app.utils;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        int i = scanner.nextInt();
        scanner.nextLine();
        return i;
    }

    public double readDouble(String prompt) {
        System.out.print(prompt);
        double d = scanner.nextDouble();
        scanner.nextLine();
        return d;
    }
}
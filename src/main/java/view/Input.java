package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/15}
 */
public class Input {
    private Scanner scanner;
    private int number;
    private String string;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public int getChoiceNumber() {
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            number = -9999;
        }
        return number;
    }
}

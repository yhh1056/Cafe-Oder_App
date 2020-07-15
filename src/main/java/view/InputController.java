package view;

import utils.MenuNameIndexOutOfBoundsException;
import utils.MenuNameOverlapException;
import utils.MenuPriceIndexOutOfBoundsException;
import utils.Validator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/15}
 */
public class InputController {
    private Scanner scanner;
    private int number;
    private String name;
    private int price;
    private Validator validator;
    private ArrayList<String> nameList;

    public InputController() {
        scanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    public int getChoiceNumber() {
        try {
            number = scanner.nextInt();
            return number;
        } catch (InputMismatchException e) {
            CustomerMessage.showInvalid();
            lineReset();
            return getChoiceNumber();
        }
    }

    public String getName()  {
        try {
            name = scanner.nextLine();
            validator.invalidNameLength(name);
            validator.registerNameIsExisted(name, nameList);
            return name;
        } catch (MenuNameIndexOutOfBoundsException | MenuNameOverlapException e) {
            System.out.println(e.getMessage());
            return getName();
        }
    }

    public int getPrice() {
        try {
            price = scanner.nextInt();
            validator.isInvalidPriceRange(price);
            return price;
        } catch (InputMismatchException e) {
            CustomerMessage.showInvalid();
            lineReset();
            return getPrice();
        } catch (MenuPriceIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            lineReset();
            return getPrice();
        }
    }

    public void lineReset() {
        scanner.nextLine();
    }

    public void requestNameList(ArrayList<String> nameList) {
        this.nameList = nameList;
    }
}

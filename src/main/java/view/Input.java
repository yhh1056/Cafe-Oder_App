package view;

import domain.Menu;
import utils.NameIndexOutOfBoundsExceptionHandler;
import utils.PriceIndexOutOfBoundsExceptionHandler;
import utils.Validator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/15}
 */
public class Input {
    private Scanner scanner;
    private int number;
    private String name;
    private int price;
    private Validator validator;
    private ArrayList<Menu> menuList;
    private int errorNumber = -9999;

    public Input() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    public int getChoiceNumber() {
        try {
            number = scanner.nextInt();
            lineReset();
            return number;
        } catch (InputMismatchException e) {
            lineReset();
            return errorNumber;
        }
    }

    public String getRegisterName()  {
        try {
            name = scanner.nextLine();
            validator.invalidNameLength(name);
            return isAlreadyExistedMenu();
        } catch (NameIndexOutOfBoundsExceptionHandler e) {
            System.out.println(e.getMessage());
            return getRegisterName();
        }
    }

    private String isAlreadyExistedMenu() {
        if (validator.isExistedMenu(name, menuList)) {
            ApplicationErrorMessage.isExisted();
            return getRegisterName();
        } else {
            return name;
        }
    }

    public int getRegisterPrice() {
        try {
            price = scanner.nextInt();
            validator.invalidPriceRange(price);
            return price;
        } catch (InputMismatchException e) {
            ApplicationErrorMessage.isInvalid();
            lineReset();
            return getRegisterPrice();
        } catch (PriceIndexOutOfBoundsExceptionHandler e) {
            System.out.println(e.getMessage());
            lineReset();
            return getRegisterPrice();
        }
    }

    public String getEqualName() {
        name = scanner.nextLine();
        if (validator.isExistedMenu(name, menuList)) {
            return name;
        } else {
            ApplicationErrorMessage.isNotFoundName();
            return getEqualName();
        }
    }

    public void getMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    private void lineReset() {
        scanner.nextLine();
    }
}

package view;

import domain.Menu;
import utils.MenuNameIndexOutOfBoundsException;
import utils.MenuPriceIndexOutOfBoundsException;
import utils.Validator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/15}
 */
public class InputCustomer {
    private Scanner scanner;
    private int number;
    private String name;
    private int price;
    private Validator validator;
    private ArrayList<Menu> menuList;

    public InputCustomer() {
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

    public String getRegisterName()  {
        name = scanner.nextLine();
        try {
            validator.invalidNameLength(name);
            if (validator.isExistedMenu(name, menuList)) {
                System.out.println("이미 존재하는 메뉴");
                return getRegisterName();
            } else
                return name;
        } catch (MenuNameIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return getRegisterName();
        }
    }

    public String getEqualName() {
        String name = scanner.nextLine();
        if (validator.isExistedMenu(name, menuList)) {
            return name;
        } else {
            CustomerMessage.showNotFoundName();
            return getEqualName();
        }
    }

    public int getPrice() {
        try {
            price = scanner.nextInt();
            validator.invalidPriceRange(price);
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

    public void getMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }
}

package view;

import controller.MenuController;
import domain.Menu;
import repository.MenuRepository;
import utils.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class Customer {
    private MenuController menuController;
    private Scanner scanner;
    private Validator validator;

    public Customer() {
        this.menuController = new MenuController(new MenuRepository());
        scanner = new Scanner(System.in);
        validator = new Validator();
    }

    public int choiceNumber() {
        return scanner.nextInt();
    }

    public void addMenuByAdmin() throws MenuNameIndexOutOfBoundsException,
            MenuPriceIndexOutOfBoundsException, MenuNameOverlapException {
        String name = scanner.next();
        int price = scanner.nextInt();
        Menu menu = new Menu(name, price);

        validator.registerNameValid(name, menuNameList());
        validator.registerPriceInvalid(price);

        menuController.addMenu(menu);
    }

    public void deleteMenuByAdmin() throws notFoundNameException, MenuNotFoundException {
        ArrayList<Menu> menuList = getMenuList();
        validator.menuIsEmpty(menuList);

        String name = scanner.next();
        validator.notfoundName(name, menuList);

        menuController.deleteMenu(name);
    }

    public void showSalesByAdmin() {
        int sales = menuController.getSales();
        System.out.println("현재 매출은 " + sales + "원 입니다");
    }

    public void showMenuListByUser() throws MenuNotFoundException {
        ArrayList<Menu> menuList = getMenuList();
        validator.menuIsEmpty(menuList);

        for (Menu menu : menuList) {
            System.out.println("메뉴 : " + menu.getName() + ", 가격 : " + menu.getPrice());
        }
    }

    public void orderMenuByUser() {
        String name = scanner.next();

        menuController.oderMenu(name);
    }

    private ArrayList<String> menuNameList() {
        return menuController.getNames();
    }

    private ArrayList<Menu> getMenuList() {
        return menuController.showMenuList();
    }
}
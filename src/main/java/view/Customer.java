package view;

import controller.MenuController;
import domain.Menu;
import repository.MenuRepository;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class Customer {
    private MenuController menuController;
    private Scanner scanner;

    public Customer() {
        this.menuController = new MenuController(new MenuRepository());
        scanner = new Scanner(System.in);
    }

    public int choiceNumber() {
        return scanner.nextInt();
    }

    public void addMenuByAdmin() {
        String name = scanner.next();
        int price = scanner.nextInt();
        Menu menu = new Menu(name, price);

        menuController.addMenu(menu);
    }

    public void deleteMenuByAdmin() {
        String menuName = scanner.next();

        menuController.deleteMenu(menuName);
    }

    public void showMenuListByUser() {
        ArrayList<Menu> menuList = menuController.showMenuList();

        for (Menu menu : menuList) {
            System.out.println("메뉴 : " + menu.getName() + ", 가격 : " + menu.getPrice());
        }
    }

    public void orderMenuByUser() {
        String name = scanner.next();

        menuController.oderMenu(name);
    }
}

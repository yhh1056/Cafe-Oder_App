package view;

import controller.MenuController;
import domain.Menu;

import java.util.Scanner;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class Input {
    private Scanner scanner;
    private MenuController menuController;

    public Input(MenuController menuController) {
        scanner = new Scanner(System.in);
        this.menuController = menuController;
    }

    public void addMenuByAdmin() {
        String name = scanner.next();
        int price = scanner.nextInt();
        Menu menu = new Menu(name, price);

        menuController.addMenu(menu);
    }
}

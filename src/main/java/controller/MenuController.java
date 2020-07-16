package controller;

import domain.Menu;
import repository.MenuRepository;
import utils.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class MenuController {
    private MenuRepository menuRepository;
    private Scanner stringScanner;
    private Validator validator;

    public MenuController() {
        this.menuRepository = new MenuRepository();
        this.stringScanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    public void addMenu(String name, int price) {
        Menu menu = new Menu(name, price);

        menuRepository.save(menu);
    }

    public void delete(String name) {
        menuRepository.deleteMenu(name);
    }

    public int getSales() {
        return menuRepository.getSales();
    }

    public void showMenuListByUser() throws NotFoundMenuException {
        ArrayList<Menu> menuList = getMenuList();
        validator.menuIsEmpty(menuList);

        for (Menu menu : menuList) {
            System.out.println("메뉴 : " + menu.getName() + ", 가격 : " + menu.getPrice());
        }
    }

    public void orderMenuByUser() throws NotFoundNameException {
        ArrayList<Menu> menuList = getMenuList();

        String name = stringScanner.nextLine();

        validator.notfoundName(name, menuList);

        menuRepository.oderMenu(name);
    }

    public ArrayList<String> getNameList() {
        return menuRepository.findNames();
    }

    private ArrayList<Menu> getMenuList() {
        return menuRepository.findAll();
    }
}
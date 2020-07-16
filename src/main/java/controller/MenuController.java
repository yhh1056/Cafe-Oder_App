package controller;

import domain.Menu;
import repository.CustomerRepository;
import utils.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class MenuController {
    private CustomerRepository customerRepository;
    private Scanner stringScanner;
    private Validator validator;

    public MenuController() {
        this.customerRepository = new CustomerRepository();
        this.stringScanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    public void addMenu(String name, int price) {
        Menu menu = new Menu(name, price);

        customerRepository.save(menu);
    }

//    public void deleteMenuByAdmin() throws NotFoundNameException, NotFoundMenuException {
//        ArrayList<Menu> menuList = getMenuList();
//        validator.menuIsEmpty(menuList);
//
//        String name = stringScanner.nextLine();
//
//        validator.notfoundName(name, menuList);
//
//        customerRepository.deleteMenu(name);
//    }

    public void showSalesByAdmin() {
        int sales = customerRepository.getSales();
        System.out.println("현재 매출은 " + sales + "원 입니다");
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

        customerRepository.oderMenu(name);
    }

    public ArrayList<String> getNameList() {
        return customerRepository.findNames();
    }

    private ArrayList<Menu> getMenuList() {
        return customerRepository.findAll();
    }

    public void delete(String name) {
        System.out.println(name + "너의 이름은?");
        customerRepository.deleteMenu(name);
    }
}
package controller;

import domain.Menu;
import repository.CustomerRepository;
import utils.*;
import view.CustomerMessage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 *
 */
public class CustomerController {
    private CustomerRepository customerRepository;
    private Scanner stringScanner;
    private Scanner intScanner;
    private Validator validator;

    public CustomerController() {
        customerRepository = new CustomerRepository();
        this.stringScanner = new Scanner(System.in);
        this.intScanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    public void addMenuByAdmin() throws MenuNameIndexOutOfBoundsException,
            MenuPriceIndexOutOfBoundsException, MenuNameOverlapException {
        String name;
        name = stringScanner.nextLine();
        int price;
        while (true) {
            try {
                price = intScanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                CustomerMessage.showInvalidPrice();
                stringScanner = new Scanner(System.in);
            }
        }
        Menu menu = new Menu(name, price);
        validator.registerNameValid(name, this.menuNameList());
        validator.registerPriceInvalid(price);

        customerRepository.save(menu);
    }

    public void deleteMenuByAdmin() throws NotFoundNameException, MenuNotFoundException {
        ArrayList<Menu> menuList = getMenuList();
        validator.menuIsEmpty(menuList);

        String name = stringScanner.nextLine();

        validator.notfoundName(name, menuList);

        customerRepository.deleteMenu(name);
    }

    public void showSalesByAdmin() {
        int sales = customerRepository.getSales();
        System.out.println("현재 매출은 " + sales + "원 입니다");
    }

    public void showMenuListByUser() throws MenuNotFoundException {
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

    private ArrayList<String> menuNameList() {
        return customerRepository.getNames();
    }

    private ArrayList<Menu> getMenuList() {
        return customerRepository.findAll();
    }
}
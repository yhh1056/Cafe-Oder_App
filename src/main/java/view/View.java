package view;

import utils.*;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class View {
    private Customer customer;
    private int choiceNumber;

    public View() {
        customer = new Customer();
    }

    public void start() {
        choiceMode();
    }

    private void choiceMode() {
        CustomerMessage.MODE_SETTING_MESSAGE();
        choiceNumber = customer.choiceNumber();

        switch (choiceNumber) {
            case 1:
                startAdmin();
                break;
            case 2:
                startUser();
                break;
            default:
                CustomerMessage.INVALID_CHOICE_MESSAGE();
                choiceMode();
        }
    }

    private void startAdmin() {
        CustomerMessage.ADMIN_CHOICE_FUNCTION_MESSAGE();
        choiceNumber = customer.choiceNumber();

        switch (choiceNumber) {
            case 1:
                registerMenu();
                break;
            case 2:
                deleteMenu();
                break;
            case 3:
                showSales();
                break;
            default:
                CustomerMessage.INVALID_CHOICE_MESSAGE();
                startAdmin();
        }
        choiceMode();
    }

    private void startUser() {
        showMenuList();
        order();
        choiceMode();
    }

    private void registerMenu() {
//        CustomerMessage.ADMIN_MENU_REGISTER_MESSAGE();
        try {
            customer.addMenuByAdmin();
        } catch (MenuNameIndexOutOfBoundsException e) {
            System.out.println("오류 이유 : " + e.getMessage());
            registerMenu();
        } catch (MenuPriceIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            registerMenu();
        } catch (MenuNameOverlapException e) {
            System.out.println("오류 이유 " + e.getMessage());
        }
    }

    private void deleteMenu() {
        try {
            customer.deleteMenuByAdmin();
        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (notFoundNameException e) {
            System.out.println(e.getMessage());
            deleteMenu();
        }
    }

    private void showMenuList() {
        CustomerMessage.USER_SHOW_MENU_LIST_MESSAGE();
        try {
            customer.showMenuListByUser();
        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
            choiceMode();
        }
    }

    private void order() {
        CustomerMessage.USER_CHOICE_MENU_MESSAGE();
        try {
            customer.orderMenuByUser();
        } catch (notFoundNameException e) {
            System.out.println(e.getMessage());
            startUser();
        }
    }

    private void showSales() {
        customer.showSalesByAdmin();
    }
}
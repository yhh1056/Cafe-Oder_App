package view;

import controller.CustomerController;
import utils.*;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class View {
    private CustomerController customer;
    private int choiceNumber;

    public View() {
        customer = new CustomerController();
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
            case 3:
                endApp();
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
            case 4:
                choiceMode();
                break;
            default:
                CustomerMessage.INVALID_CHOICE_MESSAGE();
                startAdmin();
        }
    }

    private void startUser() {
        CustomerMessage.USER_CHOICE_LIST();
        choiceNumber = customer.choiceNumber();
        switch (choiceNumber) {
            case 1:
                showMenuList();
            case 2:
                choiceMode();
            default:
                CustomerMessage.INVALID_CHOICE_MESSAGE();
                startUser();
        }
    }

    private void endApp() {
        System.exit(0);
    }

    private void registerMenu() {
        CustomerMessage.ADMIN_MENU_REGISTER_MESSAGE();
        try {
            customer.addMenuByAdmin();
            CustomerMessage.SUCCESS_MESSAGE();
            choiceMode();
        } catch (MenuNameIndexOutOfBoundsException e) {
            System.out.println("오류 이유 : " + e.getMessage());

        } catch (MenuPriceIndexOutOfBoundsException e) {
            System.out.println("오류 이유 : " + e.getMessage());

        } catch (MenuNameOverlapException e) {
            System.out.println("오류 이유 " + e.getMessage());

        } finally {
            registerMenu();
        }
    }

    private void deleteMenu() {
        CustomerMessage.ADMIN_MENU_DELETE_MESSAGE();
        try {
            customer.deleteMenuByAdmin();
            CustomerMessage.SUCCESS_MESSAGE();
            choiceMode();
        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
            startAdmin();
        } catch (NotFoundNameException e) {
            System.out.println(e.getMessage());
            deleteMenu();
        }
    }

    private void showMenuList() {
        CustomerMessage.USER_SHOW_MENU_LIST_MESSAGE();
        try {
            customer.showMenuListByUser();
            order();

        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void order() {
        CustomerMessage.USER_CHOICE_MENU_MESSAGE();
        try {
            customer.orderMenuByUser();
            CustomerMessage.USER_ORDER_SUCCESS_MESSAGE();
        } catch (NotFoundNameException e) {
            System.out.println(e.getMessage());
            startUser();
        }
    }

    private void showSales() {
        customer.showSalesByAdmin();
        choiceMode();
    }
}
package view;

import utils.MenuNameIndexOutOfBoundsException;
import utils.MenuNameOverlapException;
import utils.MenuNotFoundException;
import utils.MenuPriceIndexOutOfBoundsException;

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
        } catch (MenuNameIndexOutOfBoundsException | MenuPriceIndexOutOfBoundsException e) {
            System.out.println("오류 이유 : " + e.getMessage());
            registerMenu();
        } catch (MenuNameOverlapException e) {
            System.out.println("오류 이유 " + e.getMessage());
        }
    }

    private void deleteMenu() {
        customer.deleteMenuByAdmin();
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
        customer.orderMenuByUser();
    }

    private void showSales() {
        customer.showSalesByAdmin();
    }
}
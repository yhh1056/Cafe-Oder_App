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
        CustomerMessage.modeListMessage();
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
                CustomerMessage.invalidChoiceMessage();
                choiceMode();
        }
    }

    private void startAdmin() {
        CustomerMessage.adminChoiceListMessage();
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
                CustomerMessage.invalidChoiceMessage();
                startAdmin();
        }
    }

    private void startUser() {
        CustomerMessage.userChoiceListMessage();
        choiceNumber = customer.choiceNumber();
        switch (choiceNumber) {
            case 1:
                showMenuList();
            case 2:
                choiceMode();
            default:
                CustomerMessage.invalidChoiceMessage();
                startUser();
        }
    }

    private void endApp() {
        System.exit(0);
    }

    private void registerMenu() {
        CustomerMessage.adminRegisterMenuMessage();
        try {
            customer.addMenuByAdmin();
            CustomerMessage.successMessage();
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
        CustomerMessage.adminDeleteMenuMessage();
        try {
            customer.deleteMenuByAdmin();
            CustomerMessage.successMessage();
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
        CustomerMessage.userShowMenuListMessage();
        try {
            customer.showMenuListByUser();
            order();

        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void order() {
        CustomerMessage.userChoiceMenuMessage();
        try {
            customer.orderMenuByUser();
            CustomerMessage.userOrderSuccessMessage();
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
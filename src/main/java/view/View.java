package view;

import controller.CustomerController;
import utils.*;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class View {
    private CustomerController customerController;
    private Input input;

    public View() {
        customerController = new CustomerController();
        input = new Input();
    }

    public void start() {
        choiceMode();
    }

    private void choiceMode() {
        CustomerMessage.showMode();

        switch (input.getChoiceNumber()) {
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
                CustomerMessage.showInvalidChoice();
                choiceMode();
        }
    }

    private void startAdmin() {
        CustomerMessage.showAdminChoice();

        switch (input.getChoiceNumber()) {
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
                CustomerMessage.showInvalidChoice();
                startAdmin();
        }
    }

    private void startUser() {
        CustomerMessage.showUserChoice();

        switch (input.getChoiceNumber()) {
            case 1:
                showMenuList();
            case 2:
                choiceMode();
            default:
                CustomerMessage.showInvalidChoice();
                startUser();
        }
    }

    private void endApp() {
        System.exit(0);
    }

    private void registerMenu() {
        CustomerMessage.showMenuRegister();
        try {
            customerController.addMenuByAdmin();
            CustomerMessage.showSuccess();
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
        CustomerMessage.showDeleteMenu();
        try {
            customerController.deleteMenuByAdmin();
            CustomerMessage.showSuccess();
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
        CustomerMessage.showMenuList();
        try {
            customerController.showMenuListByUser();
            order();

        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void order() {
        CustomerMessage.showChoiceMenu();
        try {
            customerController.orderMenuByUser();
            CustomerMessage.showOderSuccess();
        } catch (NotFoundNameException e) {
            System.out.println(e.getMessage());
            startUser();
        }
    }

    private void showSales() {
        customerController.showSalesByAdmin();
        choiceMode();
    }
}
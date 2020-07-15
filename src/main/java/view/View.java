package view;

import controller.MenuController;
import utils.*;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class View {
    private MenuController menuController;
    private InputController inputController;

    public View() {
        menuController = new MenuController();
        inputController = new InputController();
    }

    public void start() {
        choiceMode();
    }

    private void choiceMode() {
        CustomerMessage.showMode();

        switch (inputController.getChoiceNumber()) {
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
                CustomerMessage.showInvalid();
                choiceMode();
        }
    }

    private void startAdmin() {
        CustomerMessage.showAdminChoice();

        switch (inputController.getChoiceNumber()) {
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
                CustomerMessage.showInvalid();
                startAdmin();
        }
        inputController.lineReset();
    }

    private void startUser() {
        CustomerMessage.showUserChoice();

        switch (inputController.getChoiceNumber()) {
            case 1:
                showMenuList();
            case 2:
                choiceMode();
            default:
                CustomerMessage.showInvalid();
                startUser();
        }
        inputController.lineReset();
    }

    private void endApp() {
        System.exit(0);
    }

    private void registerMenu() {
        CustomerMessage.showMenuRegister();

        inputController.lineReset();

        inputController.requestNameList(menuController.getNameList());
        String name = inputController.getName();
        int price = inputController.getPrice();
        menuController.addMenu(name, price);

        startAdmin();
    }

    private void deleteMenu() {
        CustomerMessage.showDeleteMenu();
        try {
            menuController.deleteMenuByAdmin();
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
            menuController.showMenuListByUser();
            order();

        } catch (MenuNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void order() {
        CustomerMessage.showChoiceMenu();
        try {
            menuController.orderMenuByUser();
            CustomerMessage.showOderSuccess();
        } catch (NotFoundNameException e) {
            System.out.println(e.getMessage());
            startUser();
        }
    }

    private void showSales() {
        menuController.showSalesByAdmin();
        choiceMode();
    }
}
package view;

import controller.MenuController;
import utils.*;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class View {
    private InputCustomer inputCustomer;
    private MenuController menuController;

    public View() {
        inputCustomer = new InputCustomer();
        menuController = new MenuController();
    }

    public void start() {
        choiceMode();
    }

    private void choiceMode() {
        CustomerMessage.showMode();

        switch (inputCustomer.getChoiceNumber()) {
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

        switch (inputCustomer.getChoiceNumber()) {
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
        inputCustomer.lineReset();
    }

    private void startUser() {
        CustomerMessage.showUserChoice();

        switch (inputCustomer.getChoiceNumber()) {
            case 1:
                showMenuList();
            case 2:
                choiceMode();
            default:
                CustomerMessage.showInvalid();
                startUser();
        }
        inputCustomer.lineReset();
    }

    private void endApp() {
        System.exit(0);
    }

    private void registerMenu() {
        CustomerMessage.showMenuRegister();
        inputCustomer.lineReset();

        inputCustomer.getNameList(menuController.getNameList());
        String name = inputCustomer.getRegisterInputName();
        int price = inputCustomer.getPrice();
        menuController.addMenu(name, price);

        startAdmin();
    }

    private void deleteMenu() {
        CustomerMessage.showDeleteMenu();
        inputCustomer.lineReset();
        inputCustomer.getNameList(menuController.getNameList());
        String name = inputCustomer.getEqualName();
        menuController.delete(name);

        //삭제할게 없을 경우 추가
        startAdmin();
    }

    private void showMenuList() {
        CustomerMessage.showMenuList();
        try {
            menuController.showMenuListByUser();
            order();

        } catch (NotFoundMenuException e) {
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
package view;

import controller.MenuController;
import utils.Validator;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class View {
    private Input input;
    private MenuController menuController;
    private Validator validator;

    public View() {
        this.input = new Input();
        this.menuController = new MenuController();
        this.validator = new Validator();
    }

    public void start() {
        choiceMode();
    }

    private void choiceMode() {
        ApplicationMessage.showMode();

        switch (input.getChoiceNumber()) {
            case 1:
                startAdmin();
                break;
            case 2:
                startCustomer();
                break;
            case 3:
                endApp();
                break;
            default:
                ApplicationErrorMessage.isInvalid();
                choiceMode();
        }
    }

    private void startAdmin() {
        ApplicationMessage.showAdminChoice();

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
                ApplicationErrorMessage.isInvalid();
                startAdmin();
        }
    }

    private void startCustomer() {
        ApplicationMessage.showUserChoice();

        switch (input.getChoiceNumber()) {
            case 1:
                order();
            case 2:
                choiceMode();
            default:
                ApplicationErrorMessage.isInvalid();
                startCustomer();
        }
    }

    private void registerMenu() {
        ApplicationMessage.showMenuRegister();

        this.getMenuListForValidation();

        String name = input.getRegisterName();
        int price = input.getRegisterPrice();
        menuController.addMenu(name, price);

        startAdmin();
    }

    private void order() {
        this.checkEmpty();

        ApplicationMessage.showOder();

        String name = input.getEqualName();
        menuController.order(name);

        ApplicationMessage.showOderSuccess();

        startCustomer();
    }

    private void deleteMenu() {
        checkEmpty();

        ApplicationMessage.showDeleteMenu();

        String name = input.getEqualName();
        menuController.delete(name);

        ApplicationMessage.showDeleteSuccess();

        startAdmin();
    }

    private void showSales() {
        int sales = menuController.getSales();

        ApplicationMessage.showSales(sales);

        startAdmin();
    }

    private void showMenuList() {
        ApplicationMessage.showMenuList(menuController.getMenuList());
    }

    private void endApp() {
        System.exit(0);
    }

    private void checkEmpty() {
        getMenuListForValidation();

        if (validator.isEmptyMenu(menuController.getMenuList())) {
            ApplicationErrorMessage.isEmptyMenu();
            choiceMode();
        }
        showMenuList();
    }

    private void getMenuListForValidation() {
        input.getMenuList(menuController.getMenuList());
    }
}
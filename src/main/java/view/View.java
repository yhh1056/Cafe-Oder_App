package view;

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
        /**
         * 예외 처리
         */
        switch (choiceNumber) {
            case 1:
                startAdmin();
                break;
            case 2:
                startUser();
                break;
        }
    }

    private void startAdmin() {
        CustomerMessage.ADMIN_CHOICE_FUNCTION_MESSAGE();
        choiceNumber = customer.choiceNumber();
        /**
         * 예외 처리
         */
        switch (choiceNumber) {
            case 1:
                registerMenu();
                break;
            case 2:
                deleteMenu();
                break;
        }
        choiceMode();
    }

    private void startUser() {
        showMenuList();
        /**
         * 메뉴가 없을 경우 예외 처리
         */
        order();
    }

    private void registerMenu() {
        customer.addMenuByAdmin();
    }

    private void deleteMenu() {
        customer.deleteMenuByAdmin();
    }

    private void showMenuList() {
        CustomerMessage.USER_SHOW_MENU_LIST_MESSAGE();
        customer.showMenuListByUser();
    }

    private void order() {
        CustomerMessage.USER_CHOICE_MENU_MESSAGE();
        customer.orderMenuByUser();
    }
}
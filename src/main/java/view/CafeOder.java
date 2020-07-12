package view;

import controller.MenuController;
import repository.MenuRepository;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class CafeOder {
    private Input input;

    public void start() {
        input = new Input(new MenuController(new MenuRepository()));
        System.out.println("메뉴를 입력해주세요");
        startAdmin();
    }

    private void startAdmin() {
        registerMenu();
    }

    private void registerMenu() {
        input.addMenuByAdmin();
    }
}

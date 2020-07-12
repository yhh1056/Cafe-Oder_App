package controller;

import domain.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MenuRepository;
import view.Input;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
class MenuControllerTest {
    private MenuController menuController;
    private MenuRepository menuRepository;

    @BeforeEach
    void setUp() {
        this.menuRepository = new MenuRepository();
        this.menuController = new MenuController(menuRepository);
    }

    @Test
    void 유효한_메뉴를_레퍼지토리에_추가() {
        Menu menu = new Menu("아메리카노", 4000);
        menuController.addMenu(menu);

        assertEquals(menuRepository.getMenuName(0), "아메리카노");
    }
}
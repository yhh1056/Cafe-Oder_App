package controller;

import domain.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MenuRepository;

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
    void 유효한_메뉴를_추가_한다() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);
        menuController.addMenu(coffee);
        menuController.addMenu(latte);

        assertEquals(menuRepository.getMenuName(1L), "아메리카노");
        assertEquals(menuRepository.getMenuName(2L), "라떼");
    }
}
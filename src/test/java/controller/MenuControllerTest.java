package controller;

import domain.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MenuRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(menuRepository.getMenu(1L).getName(), "아메리카노");
        assertEquals(menuRepository.getMenu(2L).getName(), "라떼");
    }

    @Test
    void 아이디로_메뉴를_삭제_한다() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);
        menuController.addMenu(coffee);
        menuController.addMenu(latte);

        menuRepository.deleteById(2L);

        assertThat(menuRepository.getMenu(2L)).isNull();
    }
}
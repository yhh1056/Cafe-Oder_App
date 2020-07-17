package controller;

import domain.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.MenuRepository;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
class MenuRepositoryTest {
    private MenuRepository menuRepository;

    @BeforeEach
    void setUp() {
        this.menuRepository = new MenuRepository();
    }

    @Test
    void 메뉴추가() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);

        menuRepository.save(coffee);
        menuRepository.save(latte);

        assertThat(menuRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    void 메뉴삭제() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);

        menuRepository.save(coffee);
        menuRepository.save(latte);

        menuRepository.deleteMenu("라떼");

        assertThat(menuRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void 주문() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);

        menuRepository.save(coffee);
        menuRepository.save(latte);

        menuRepository.oderMenu(coffee.getName());
        menuRepository.oderMenu(latte.getName());

        assertThat(menuRepository.getSales()).isEqualTo(8500);
    }
}
package utils;

import domain.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * author {yhh1056}
 * Create by {2020/07/17}
 */
class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = new Validator();
    }

    @Test
    void 유효하지_않은_이름으로_등록() {
        String name = "15글자가 넘는 이름을 주입 합니다.";

        assertThrows(NameIndexOutOfBoundsExceptionHandler.class,
                () -> validator.invalidNameLength(name));
    }

    @Test
    void 유효하지_않은_가격으로_등록() {
        int invalidPrice = 1000000;

        assertThrows(PriceIndexOutOfBoundsExceptionHandler.class,
                () -> validator.invalidPriceRange(invalidPrice));
    }

    @Test
    void 메뉴가_이미_존재() {
        Menu coffee = new Menu("coffee", 4000);
        Menu test = new Menu("test", 4000);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(coffee);
        menuList.add(test);

        assertTrue(validator.isExistedMenu(test.getName(), menuList));

    }

    @Test
    void 메뉴가_없을_경우() {
        ArrayList<Menu> menuList = new ArrayList<>();

        assertTrue(validator.isEmptyMenu(menuList));
    }
}
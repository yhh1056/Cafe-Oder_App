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
    void invalidNameLength() {
        String name = "15글자가 넘는 이름을 주입 합니다.";

        assertThrows(MenuNameIndexOutOfBoundsException.class, () -> {
            validator.invalidNameLength(name);
        });
    }

    @Test
    void isExistedMenu() {
        Menu coffee = new Menu("coffee", 4000);
        Menu test = new Menu("test", 4000);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(coffee);
        menuList.add(test);

        assertTrue(validator.isExistedMenu(test.getName(), menuList));

    }

    @Test
    void isEmptyMenu() {
        ArrayList<Menu> menuList = new ArrayList<>();

        assertTrue(validator.isEmptyMenu(menuList));
    }

    @Test
    void isFoundName() {
        Menu coffee = new Menu("coffee", 4000);
        Menu test = new Menu("test", 4000);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(coffee);
        menuList.add(test);

        assertTrue(validator.isFoundName("coffee", menuList));
    }

    @Test
    void isNotFoundName() {
        Menu coffee = new Menu("coffee", 4000);
        Menu test = new Menu("test", 4000);

        ArrayList<Menu> menuList = new ArrayList<>();
        menuList.add(coffee);
        menuList.add(test);

        assertFalse(validator.isFoundName("invalid", menuList));
    }

    @Test
    void isInvalidPriceRange() {
        int invalidPrice = 1000000;

        assertThrows(MenuPriceIndexOutOfBoundsException.class,
                () -> validator.invalidPriceRange(invalidPrice));
    }
}
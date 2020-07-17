package utils;

import domain.Menu;

import java.util.ArrayList;

/**
 * author {yhh1056}
 * Create by {2020/07/14}
 */
public class Validator {
    private final int nameValidLength = 15;
    private final int minPriceValid = 100;
    private final int maxPriceValid = 100000;

    public void invalidNameLength(String name) throws NameIndexOutOfBoundsExceptionHandler {
        if (name.length() > nameValidLength) {
            throw new NameIndexOutOfBoundsExceptionHandler("이름은 15글자를 넘길 수 없습니다.");
        }
    }

    public void invalidPriceRange(int price) throws PriceIndexOutOfBoundsExceptionHandler {
        if (price < minPriceValid || maxPriceValid < price) {
            throw new PriceIndexOutOfBoundsExceptionHandler("가격은 100원 이샹 100,000원 이하 입니다");
        }
    }

    public boolean isExistedMenu(String name, ArrayList<Menu> menuList) {
        for (Menu menu : menuList) {
            if (menu.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmptyMenu(ArrayList<Menu> menus) {
        return menus.isEmpty();
    }
}

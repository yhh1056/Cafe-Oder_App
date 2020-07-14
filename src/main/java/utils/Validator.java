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

    public boolean registerNameValid(String name, ArrayList<String> names) throws MenuNameIndexOutOfBoundsException, MenuNameOverlapException {
        invalidNameLength(name);
        NameIsExisted(name, names);
        return true;
    }

    public boolean registerPriceInvalid(int price) throws MenuPriceIndexOutOfBoundsException {
        invalidPriceRange(price);
        return true;
    }

    public void menuIsEmpty(ArrayList<Menu> menus) throws MenuNotFoundException {
        if (menus.isEmpty()) {
            throw new MenuNotFoundException("현재 메뉴가 존재하지 않습니다.");
        }
    }

    public void notfoundName(String name, ArrayList<Menu> menuList) throws notFoundNameException {
        for (Menu menu : menuList) {
            if (!menu.getName().equals(name)) {
                throw new notFoundNameException("해당 메뉴가 존재하지 않습니다.");
            }
        }
    }

    private void NameIsExisted(String name, ArrayList<String> names) throws MenuNameOverlapException {
        for (String readName : names) {
            if (readName.equals(name)) {
                throw new MenuNameOverlapException("이미 존재하는 메뉴입니다.");
            }
        }
    }

    private void invalidNameLength(String name) throws MenuNameIndexOutOfBoundsException {
        if (name.length() > nameValidLength) {
            throw new MenuNameIndexOutOfBoundsException("이름은 15글자를 넘길 수 없습니다.");
        }
    }

    private void invalidPriceRange(int price) throws MenuPriceIndexOutOfBoundsException {
        if (price < minPriceValid || price > maxPriceValid) {
            throw new MenuPriceIndexOutOfBoundsException("가격은 100원 이샹 100,000원 이하 입니다");
        }
    }
}

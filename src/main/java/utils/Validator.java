package utils;

import domain.Menu;

import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * author {yhh1056}
 * Create by {2020/07/14}
 */
public class Validator {
    private final int nameValidLength = 15;
    private final int minPriceValid = 100;
    private final int maxPriceValid = 100000;

    public void invalidNameLength(String name) throws MenuNameIndexOutOfBoundsException {
        if (name.length() > nameValidLength) {
            throw new MenuNameIndexOutOfBoundsException("이름은 15글자를 넘길 수 없습니다.");
        }
    }

    public void invalidPriceRange(int price) throws MenuPriceIndexOutOfBoundsException {
        if (price < minPriceValid || price > maxPriceValid) {
            throw new MenuPriceIndexOutOfBoundsException("가격은 100원 이샹 100,000원 이하 입니다");
        }
    }

    public ArrayList<String> getNames(ArrayList<Menu> menuList) {
        if (menuList.isEmpty()) {
            throw new NullPointerException();
        } else {
            return menuList.stream().map(Menu::getName)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }
    //뒷 메뉴를 조회하면 그만큼 비효율적이다.
    public boolean isExistedMenu(String name, ArrayList<Menu> menuList) {
        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    public boolean isEmptyMenu(ArrayList<Menu> menus) {
        if (menus.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFoundName(String name, ArrayList<Menu> menuList) {
        for (Menu menu : menuList) {
            if (menu.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}

package utils;

import java.util.ArrayList;

/**
 * author {yhh1056}
 * Create by {2020/07/14}
 */
public class Validator {
    int nameValidLength = 15;
    int minPriceValid = 100;
    int maxPriceValid = 100000;

    public boolean nameValid(String name, ArrayList<String> names) throws MenuNameIndexOutOfBoundsException, MenuNameOverlapException {
        isNameLength(name);
        isNameOverlap(name, names);
        return true;
    }

    public boolean priceValid(int price) throws MenuPriceIndexOutOfBoundsException {
        isPriceValid(price);
        return true;
    }

    private void isNameOverlap(String name, ArrayList<String> names) throws MenuNameOverlapException {
        for (String readName : names) {
            if (readName.equals(name)) {
                throw new MenuNameOverlapException("이미 존재하는 메뉴입니다.");
            }
        }
    }

    private void isNameLength(String name) throws MenuNameIndexOutOfBoundsException {
        if (name.length() > nameValidLength) {
            throw new MenuNameIndexOutOfBoundsException("이름은 15글자를 넘길 수 없습니다.");
        }
    }

    private void isPriceValid(int price) throws MenuPriceIndexOutOfBoundsException {
        if (price < minPriceValid && price > maxPriceValid) {
            throw new MenuPriceIndexOutOfBoundsException("가격은 100원 이샹 100,000원 이하 입니다");
        }
    }
}

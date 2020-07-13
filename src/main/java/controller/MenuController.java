package controller;

import domain.Menu;
import repository.MenuRepository;

import java.util.ArrayList;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 * Class information : repository에 메뉴를 추가합니다.
 */
public class MenuController {
    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public void deleteMenu(String name) {
        menuRepository.deleteByName(name);
    }

    public ArrayList<Menu> showMenuList() {
        return menuRepository.findAll();
    }

    public void oderMenu(String name) {
        menuRepository.oderByName(name);
    }

    public int getSales() {
        return menuRepository.getSales();
    }
}
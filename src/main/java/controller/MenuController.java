package controller;

import domain.Menu;
import repository.MenuRepository;

import java.util.ArrayList;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class MenuController {
    private MenuRepository menuRepository;

    public MenuController() {
        this.menuRepository = new MenuRepository();
    }

    public void addMenu(String name, int price) {
        Menu menu = new Menu(name, price);

        menuRepository.save(menu);
    }

    public void delete(String name) {
        menuRepository.deleteMenu(name);
    }

    public int getSales() {
        return menuRepository.getSales();
    }

    public ArrayList<Menu> getMenuList() {
        return menuRepository.findAll();
    }

    public void order(String name) {
        menuRepository.oderMenu(name);
    }
}
package repository;

import domain.Menu;

import java.util.ArrayList;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class MenuRepository implements MenuRepositoryInterface {
    private ArrayList<Menu> menuList;
    private int sales = 0;

    public MenuRepository() {
        this.menuList = new ArrayList<>();
    }

    @Override
    public ArrayList<Menu> findAll() {
        return this.menuList;
    }

    @Override
    public void save(Menu menu) {
        this.menuList.add(menu);
    }

    @Override
    public void deleteMenu(String name) {
        menuList.removeIf(menu -> name.equals(menu.getName()));
    }

    @Override
    public void oderMenu(String name) {
        for (Menu menu : menuList) {
            if (name.equals(menu.getName())) {
                sales += menu.getPrice();
            }
        }
    }

    @Override
    public int getSales() {
        return this.sales;
    }
}
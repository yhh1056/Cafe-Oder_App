package repository;

import domain.Menu;

import java.util.ArrayList;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class MenuRepository implements MenuInterface {
    private ArrayList<Menu> menuList;
    private int sales = 0;

    public MenuRepository() {
        this.menuList = new ArrayList<>();
    }

    @Override
    public void save(Menu menu) {

        menuList.add(menu);
    }

    @Override
    public void deleteByName(String name) {
        for (int index = 0; index < menuList.size(); index++) {
            isEqualName(name, index);
        }
    }

    @Override
    public ArrayList<Menu> findAll() {
        return this.menuList;
    }

    @Override
    public void oderByName(String name) {
        for (Menu menu : menuList) {
            if (menu.getName().equals(name)) {
                sales += menu.getPrice();
            }
        }
    }

    @Override
    public int getSales() {
        return sales;
    }

    @Override
    public ArrayList<String> getNames() {
        ArrayList<String> nameList = new ArrayList<>();
        for (Menu menu : menuList) {
            nameList.add(menu.getName());
        }
        return nameList;
    }

    private void isEqualName(String name, int index) {
        if (menuList.get(index).getName().equals(name)) {
            menuList.remove(index);
        }
    }
}
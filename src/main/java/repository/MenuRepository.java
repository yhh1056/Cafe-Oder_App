package repository;

import domain.Menu;

import java.util.ArrayList;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class MenuRepository implements MenuInterface {
    private ArrayList<Menu> menuList;

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

    private void isEqualName(String name, int index) {
        if (menuList.get(index).getName().equals(name)) {
            menuList.remove(index);
        }
    }
}
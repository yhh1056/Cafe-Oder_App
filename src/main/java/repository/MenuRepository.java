package repository;

import domain.Menu;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class MenuRepository implements MenuInterface {
    private HashMap<Long, Menu> menuList;
    private ArrayList<Menu> menus;

    public MenuRepository() {
        this.menuList = new HashMap<>();
        this.menus = new ArrayList<>();
    }

    @Override
    public void save(Menu menu) {
        menuList.put(menu.getId(), menu);
    }

    @Override
    public void deleteById(Long id) {
        menuList.remove(id);
    }

    @Override
    public ArrayList<Menu> findAll() {
        for (Long key : menuList.keySet()) {

            Menu menu = menuList.get(key);
            menus.add(menu);
        }
        return menus;
    }

    //테스트를 위해 임시로 만듦
    public Menu getMenu(Long id) {
        return menuList.get(id);
    }
}
package repository;

import domain.Menu;

import java.util.HashMap;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class MenuRepository implements MenuInterface {
    private HashMap<Long, Menu> menuList;

    public MenuRepository() {
        this.menuList = new HashMap<>();
    }

    @Override
    public void save(Menu menu) {
        menuList.put(menu.getId(), menu);
    }

    @Override
    public void deleteById(Long id) {
        menuList.remove(id);
        System.out.println(menuList.keySet());
        System.out.println(menuList.get(2L));
    }

    //테스트를 위해 임시로 만듦
    public Menu getMenu(Long id) {
        return menuList.get(id);
    }
}
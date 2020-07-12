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
    public void addByMenuList(Menu menu) {
        menuList.put(menu.getId(), menu);
    }

    //테스트코드를 위해 임시적으로 만듦
    public String getMenuName(Long id) {
        return menuList.get(id).getName();
    }
}

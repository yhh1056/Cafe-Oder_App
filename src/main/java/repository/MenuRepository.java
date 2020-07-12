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
    public void addByMenuList(Menu menu) {
        menuList.add(menu);
    }

    //테스트코드를 위해 임시적으로 만듦
    public String getMenuName(int input) {
        return menuList.get(input).getName();
    }
}

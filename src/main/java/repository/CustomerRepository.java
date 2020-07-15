package repository;

import domain.Menu;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class CustomerRepository implements CustomerInterface {
    private ArrayList<Menu> menuList;
    private int sales = 0;

    public CustomerRepository() {
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
    public void oderMenu(String name) {
        for (Menu menu : this.menuList) {
            if (name.equals(menu.getName())) {
                this.sales += menu.getPrice();
            }
        }
    }

    @Override
    public void deleteMenu(String name) {
        for (int i = 0; i < this.menuList.size(); i++) {
            if (name.equals(menuList.get(i))) {
                this.menuList.remove(i);
            }
        }
    }

    @Override
    public int getSales() {
        return this.sales;
    }

    @Override
    public ArrayList<String> findNames() {
        return this.menuList.stream().map(Menu::getName)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
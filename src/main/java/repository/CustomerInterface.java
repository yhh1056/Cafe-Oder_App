package repository;

import domain.Menu;

import java.util.ArrayList;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public interface CustomerInterface {
    ArrayList<Menu> findAll();

    void save(Menu menu);

    void oderMenu(String name);

    void deleteMenu(String name);

    int getSales();

    ArrayList<String> findNames();
}
package repository;

import domain.Menu;

import java.util.ArrayList;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public interface MenuInterface {
    void save(Menu menu);

    void deleteById(Long id);

    ArrayList<Menu> findAll();
}
package controller;

import domain.Menu;
import repository.MenuRepository;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 * Class information : repository에 메뉴를 추가합니다.
 */
public class MenuController {
    private MenuRepository menuRepository;

    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenu(Menu menu) {
        menuRepository.save(menu);
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }
}
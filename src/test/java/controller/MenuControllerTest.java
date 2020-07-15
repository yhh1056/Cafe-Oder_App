package controller;

import domain.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.CustomerRepository;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
class MenuControllerTest {
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        this.customerRepository = new CustomerRepository();
    }

    @Test
    void 유효한_메뉴를_추가_한다() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);
        customerRepository.save(coffee);
        customerRepository.save(latte);

        assertEquals(customerRepository.findAll().get(0).getName(), "아메리카노");
        assertEquals(customerRepository.findAll().get(1).getName(), "라떼");
    }

    @Test
    void 아이디로_메뉴를_삭제_한다() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);
        customerRepository.save(coffee);
        customerRepository.save(latte);

        customerRepository.deleteMenu("아메리카노");

        assertThat(customerRepository.findAll().size()).isEqualTo(1);
    }

    @Test
    void 메뉴_전체_조회() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);
        customerRepository.save(coffee);
        customerRepository.save(latte);

        ArrayList<Menu> menuList =  customerRepository.findAll();

        assertThat(menuList).size().isEqualTo(2);
        assertThat(menuList.get(0).getName()).isEqualTo("아메리카노");
        assertThat(menuList.get(0).getName()).isEqualTo("아메리카노");
    }

    @Test
    void 주문() {
        Menu coffee = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 4500);
        customerRepository.save(coffee);
        customerRepository.save(latte);
    }
}
package domain;

/**
 * @author {yhh1056}
 * Create by {2020/07/12}
 */
public class Menu {
    private String name;
    private int price;

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}

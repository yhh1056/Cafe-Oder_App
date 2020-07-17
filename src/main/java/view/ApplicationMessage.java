package view;

import domain.Menu;

import java.util.ArrayList;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class ApplicationMessage {
    public static void showMode() {
        System.out.println( "1: 관리자 모드, 2: 사용자 모드, 3: 어플 종료");
    }

    public static void showAdminChoice() {
        System.out.println("1. 메뉴를 등록합니다.");
        System.out.println("2. 메뉴를 삭제합니다.");
        System.out.println("3. 매출을 확인합니다.");
        System.out.println("4. 뒤로 갑니다.");
    }

    public static void showUserChoice() {
        System.out.println("1. 주문합니다.");
        System.out.println("2. 뒤로 갑니다.");
    }

    public static void showMenuRegister() {
        System.out.println("등록할 메뉴 이름과 가격을 입력해주세요. (엔터 기준)");
        System.out.println("이름은 15글자 이하로 가격은 100원 이상 100,000원 이하입니다.");
    }

    public static void showDeleteMenu() {
        System.out.println("삭제할 메뉴 이름을 입력해주세요.");
    }

    public static void showDeleteSuccess() {
        System.out.println("삭제되었습니다.");
    }

    public static void showOder() {
        System.out.println("주문 하실 음료를 이름으로 입력해주세요");
    }

    public static void showOderSuccess() {
        System.out.println("주문이 완료 되었습니다. 맛있게 드세요.");
    }

    public static void showSales(int sales) {
        System.out.println("현재 매출은 " + sales + "원 입니다.");
    }

    public static void showMenuList(ArrayList<Menu> menuList) {
        for (Menu menu : menuList) {
            System.out.println("┌-----------------┐");
            System.out.println(menu.getName() + " "
                    + menu.getPrice() + "원");
            System.out.println("└-----------------┘ ");
        }
    }
}

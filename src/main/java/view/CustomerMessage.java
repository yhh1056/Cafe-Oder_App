package view;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class CustomerMessage {

    public static void MODE_SETTING_MESSAGE() {
        System.out.println( "1: 관리자 모드, 2: 사용자 모드를 입력해주세요.");
    }

    public static void ADMIN_CHOICE_FUNCTION_MESSAGE() {
        System.out.println("1. 메뉴를 등록합니다.");
        System.out.println("2. 메뉴를 삭제합니다.");
    }

    public static void USER_SHOW_MENU_LIST_MESSAGE() {
        System.out.println("메뉴판 입니다.");
    }
}

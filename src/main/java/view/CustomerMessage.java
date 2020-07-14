package view;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class CustomerMessage {
    public static void INVALID_CHOICE_MESSAGE() {
        System.out.println("유효하지 않은 선택 입니다. 다시 선택해 주세요.");
    }

    public static void MODE_SETTING_MESSAGE() {
        System.out.println( "1: 관리자 모드, 2: 사용자 모드, 3: 어플 종료");
    }

    public static void SUCCESS_MESSAGE() {
        System.out.println("성공");
    }

    public static void ADMIN_CHOICE_FUNCTION_MESSAGE() {
        System.out.println("1. 메뉴를 등록 합니다.");
        System.out.println("2. 메뉴를 삭제 합니다.");
        System.out.println("3. 매출을 확인 합니다.");
    }

    public static void ADMIN_MENU_REGISTER_MESSAGE() {
        System.out.println("등록할 메뉴 이름과 가격을 입력해주세요. (엔터 기준)");
        System.out.println("이름은 15글자 이하로 가격은 100원 이상 100,000원 이하입니다.");
    }

    public static void ADMIN_MENU_DELETE_MESSAGE() {
        System.out.println("삭제할 메뉴 이름을 입력해주세요.");
    }
    public static void USER_SHOW_MENU_LIST_MESSAGE() {
        System.out.println("메뉴판 입니다.");
    }

    public static void USER_CHOICE_MENU_MESSAGE() {
        System.out.println("메뉴를 선택해 주세요.");
    }
}

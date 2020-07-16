package view;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class CustomerMessage {
    public static void showInvalid() {
        System.out.println("유효하지 않은 입력입니다. 올바른 값으로 입력해주세요.");
    }

    public static void showMode() {
        System.out.println( "1: 관리자 모드, 2: 사용자 모드, 3: 어플 종료");
    }

    public static void showSuccess() {
        System.out.println("성공");
    }

    public static void showAdminChoice() {
        System.out.println("1. 메뉴를 등록 합니다.");
        System.out.println("2. 메뉴를 삭제 합니다.");
        System.out.println("3. 매출을 확인 합니다.");
        System.out.println("4. 뒤로 갑니다.");
    }

    public static void showUserChoice() {
        System.out.println("1. 주문 합니다.");
        System.out.println("2. 뒤로 갑니다.");
    }

    public static void showMenuRegister() {
        System.out.println("등록할 메뉴 이름과 가격을 입력해주세요. (엔터 기준)");
        System.out.println("이름은 15글자 이하로 가격은 100원 이상 100,000원 이하입니다.");
    }

    public static void showDeleteMenu() {
        System.out.println("삭제할 메뉴 이름을 입력해주세요.");
    }

    public static void showMenuList() {
        System.out.println("메뉴판 입니다.");
    }
    public static void showChoiceMenu() {
        System.out.println("메뉴를 선택해 주세요.");
    }

    public static void showOderSuccess() {
        System.out.println("주문이 완료 되었습니다. 맛있게 드세요.");
    }

    public static void showIsExisted() {
        System.out.println("이미 존재 하는 메뉴 입니다.");
    }

    public static void showNotFoundName() {
        System.out.println("해당 메뉴를 찾을 수 없습니다.");
    }

    public static void showSales(int sales) {
        System.out.println("현재 매출은 " + sales + "원 입니다.");
    }
}

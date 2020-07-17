package view;

/**
 * author {yhh1056}
 * Create by {2020/07/13}
 */
public class ApplicationErrorMessage {
    public static void isInvalid() {
        System.out.println("유효하지 않은 입력입니다. 올바른 값으로 입력해주세요.");
    }

    public static void isExisted() {
        System.out.println("이미 존재 하는 메뉴입니다.");
    }

    public static void isEmptyMenu() {
        System.out.println("현재 메뉴가 없습니다. 처음으로 돌아갑니다.");
    }

    public static void isNotFoundName() {
        System.out.println("해당 메뉴를 찾을 수 없습니다.");
    }
}

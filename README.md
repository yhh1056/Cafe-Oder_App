### 기능 요구 사항

- 카페 주문 앱에는 관리자와 고객이 있습니다.
- 어플 실행시 관리자 모드와 고객 모드를 물어봅니다.
- 기능 사용 후 어플을 종료 할 것인지 물어봅니다.

- 관리자 선택 시 관리자 기능 목록이 보여집니다.
- 관리자는 메뉴를 추가 할 수 있습니다.
- 관리자는 메뉴를 삭제 할 수 있습니다.
- 관리자는 총 매출을 볼 수 있습니다.
- 관리자는 마감을 실행하면 매출이 지워집니다.

- 고객 선택시 메뉴판이 보여집니다.
- 고객은 음료를 주문 할 수 있습니다.

### 기능 세부 사항

- 관리자는 음료를 하나씩 추가 할 수 있습니다.
- 관리자는 음료 등록 시 메뉴 이름과 가격을 입력해야 합니다.
- 관리자는 메뉴 추가시 id가 주어지며 1씩 증가합니다.
- 관리자는 메뉴를 삭제할 때 번호로 삭제가 가능합니다. (번호 삭제 시 오름차순으로 재정렬)

- 고객은  메뉴별로 주문이 가능하고 입력 후 수량을 물어봅니다.

### 조건 사항

- 메뉴 이름에는 띄어쓰기가 들어 갈 수 있고 20글자 이하입니다.
- 가격은 100원 이상 100,000원 이하 입니다.
- 메뉴 추가, 삭제 , 주문은 하나씩만 가능합니다.
- 객체지향의 원칙을 최대한 지키면서 코드를 작성합니다.
- 기능 단위로 커밋합니다.
- 기능 목록별로 풀 리퀘스트 합니다.
- TDD기반으로 코드를 작성합니다.

### 추가 예정 기능

- 적립 기능이 추가됩니다.

### 기능 목록 (지라 사용)

- 입출력
    - 사용 모드
    - 메뉴 구성
    - 메뉴 삭제
    - 메뉴 확인
    - 주문
    - 매출 상황
    - 기능 종료
    - 어플 종료
- 관리자 기능
    - 메뉴 추가
    - 메뉴 삭제
    - 매출
    - 마감
- 고객 기능
    - 주문
- 예외 처리
    - 가격 범위가 다를 경우
    - 메뉴 이름이 20글자가 넘어갈 경우
    - 리스트에 없는 id를 삭제 할 경우
    - 메뉴이름이 중복될 경우

### 기능 요구사항 작성 이후 작성한 내용
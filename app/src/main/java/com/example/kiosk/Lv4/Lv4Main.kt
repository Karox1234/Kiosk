package com.example.kiosk.Lv4
//클래스 별로 파일을 나눠서 관리함(5번 피드백)
fun main() {
    val stakeMenuItem = listOf(
        FoodMenu("안심", 11.9, "스테이크의 정석 안심부위"),
        FoodMenu("등심", 10.9, "마블링이 풍부한 등심"),
        FoodMenu("T본", 12.9, "풍부한 맛을 즐기고 싶으신분")
    )

    val meatMenuItem = listOf(
        FoodMenu("삼겹살", 6.9, "한국인의 소울푸드"),
        FoodMenu("목살", 5.9, "기름이 적어 담백한 그맛"),
        FoodMenu("갈매기살", 7.9, "오늘의 특수부위")
    )

    val drinkMenuItem = listOf(
        FoodMenu("탄산음료", 2.5, "청량감 최고"),
        FoodMenu("맥주", 2.5, "목으로 넘어가는 시원한 한잔"),
        FoodMenu("소주", 4.0, "삼겹살엔 소주 한잔"),
        FoodMenu("와인", 8.9, "스테이크와 함께하는 최고의 선택")
    )
    val mainMenu = listOf(
        MenuItem("스테이크류", "육즙이 넘치는 스테이크!"),
        MenuItem("구이류", "맛있는 고기들을 한 자리에!"),
        MenuItem("음료 및 주류", "찰떡궁합 음료와 주류들!"),
        MenuItem("주문 취소", "주문 취소"),
        MenuItem("종료", "프로그램을 종료합니다")
    )
    //Menu 클래스에서 직접 메뉴를 생성하던걸 여기서 만들어서 해줌 (2번 피드백 내용)
    //mainMeun가 원래 fun 으로 출력되게 한걸 MenuItem 클래스로 만들고 상속하여 FoodMenu까지 통일함 (1/3번 피드백 내용)

    val menu = Menu(stakeMenuItem, meatMenuItem, drinkMenuItem, mainMenu)
    val restaurant = Restaurant(menu)
    restaurant.start()
}


//피드백 내용
//1. mainMenu()에서 표기한 상위메뉴는 공통적인 특성이 있기에 클래스로 생성하는 방법을 시도해도 좋을 것같아요.
//2. 클래스는 객체를 만들기 위한 것이라는 것을 명심해 주세요. 클래스(Menu) 내에서 직접 메뉴를 생성하며 클래스 프로퍼티에 할당한 방식은 좋지않습니다. 각 클래스를 인스턴스화할 때(Main클래스) 매개변수로 넣는게 좋을 것 같아요.
//3.Stake, Meat, Drink는 동일한 책임을 가진 클래스네요. FoodMenu클래스로 통합하면 중복코드를 없앨 수 잇을 것같아요. 그러면 stakeMenu, meatMenu, drinkMenu의 중복도 제거할 수 있겠네요.
//4. order class에서 items리스트에 요소를 추가/삭제할 때, 수기로 작성된 String을 매개변수로 받아 설정하셨군요. 이 부분은 사이드이팩트에 여지가 많아서 메뉴를 매개변수를 받도록 수정했으면 합니다.
//5. 클래스로 별도의 파일로 나눠 관리하면 가독성이 개선될 것같습니다.
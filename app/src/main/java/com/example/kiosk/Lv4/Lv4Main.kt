package com.example.kiosk.Lv4

fun main() {

    val restaurant = Restaurant()
    restaurant.start()
}




//피드백 내용
//1. mainMenu()에서 표기한 상위메뉴는 공통적인 특성이 있기에 클래스로 생성하는 방법을 시도해도 좋을 것같아요.
//2. 클래스는 객체를 만들기 위한 것이라는 것을 명심해 주세요. 클래스(Menu) 내에서 직접 메뉴를 생성하며 클래스 프로퍼티에 할당한 방식은 좋지않습니다. 각 클래스를 인스턴스화할 때(Main클래스) 매개변수로 넣는게 좋을 것 같아요.
//3.Stake, Meat, Drink는 동일한 책임을 가진 클래스네요. FoodMenu클래스로 통합하면 중복코드를 없앨 수 잇을 것같아요. 그러면 stakeMenu, meatMenu, drinkMenu의 중복도 제거할 수 있겠네요.
//4. order class에서 items리스트에 요소를 추가/삭제할 때, 수기로 작성된 String을 매개변수로 받아 설정하셨군요. 이 부분은 사이드이팩트에 여지가 많아서 메뉴를 매개변수를 받도록 수정했으면 합니다.
//5. 클래스로 별도의 파일로 나눠 관리하면 가독성이 개선될 것같습니다.
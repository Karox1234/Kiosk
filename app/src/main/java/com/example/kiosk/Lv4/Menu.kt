package com.example.kiosk.Lv4

class Menu {
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

    fun displayMainMenu(items: List<MenuItem>) {
        println("원하시는 메뉴를 선택하세요")
        items.forEachIndexed { index, item ->
            println("${index + 1}. ${item.name} | ${item.content}")
        }
    }

    fun displayFoodMenu(items: List<FoodMenu>) {
        println("원하시는 메뉴를 선택하세요")
        items.forEachIndexed { index, item ->
            println("${index + 1}. ${item.name} | ${item.price}원 : ${item.content}")
        }
        println("${items.size + 1}. 전 메뉴판으로 돌아가기")
    }
}
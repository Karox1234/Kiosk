package com.example.kiosk.Lv4
//클래스 별로 파일을 나눠서 관리함(5번 피드백)
class Menu(
    val stakeMenuItem: List<FoodMenu>,
    val meatMenuItem: List<FoodMenu>,
    val drinkMenuItem: List<FoodMenu>,
    val mainMenu: List<MenuItem>
)
{

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
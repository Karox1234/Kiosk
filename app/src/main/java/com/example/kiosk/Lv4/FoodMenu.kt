package com.example.kiosk.Lv4
//클래스 별로 파일을 나눠서 관리함(5번 피드백)
class FoodMenu(name: String, price: Double, content: String) : MenuItem(name, content) {
    var price: Double

    init {
        this.price = price
    }
}
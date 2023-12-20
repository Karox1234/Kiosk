package com.example.kiosk.Lv4

class FoodMenu(name: String, price: Double, content: String) : MenuItem(name, content) {
    var price: Double

    init {
        this.price = price
    }
}
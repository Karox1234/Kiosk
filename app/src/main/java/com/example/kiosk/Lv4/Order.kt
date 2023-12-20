package com.example.kiosk.Lv4

class Order {
    val items = ArrayList<FoodMenu>()

    fun addItem(item: FoodMenu) {
        println("${item.name} 선택 완료")
        items.add(item)
    }

    fun removeItem(item: FoodMenu) {
        println("${item.name} 삭제 완료")
        items.remove(item)
    }

    fun displayOrderItems() {
        if (items.isNotEmpty()) {
            println("주문 내역:")
            items.forEachIndexed { index, item ->
                println("${index + 1}. ${item.name} - 가격: ${item.price}원")
            }
        } else {
            println("이용해 주셔서 감사합니다.")
        }
    }

    fun isNotEmpty(): Boolean {
        return items.isNotEmpty()
    }

    fun contains(item: FoodMenu): Boolean {
        return items.contains(item)
    }

    fun err() {
        System.err.println("다시 올바른 번호를 입력해주세요")
    }
}
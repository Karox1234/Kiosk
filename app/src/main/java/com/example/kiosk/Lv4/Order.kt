package com.example.kiosk.Lv4
//클래스 별로 파일을 나눠서 관리함(5번 피드백)
class Order {
    val items = ArrayList<FoodMenu>()
//기존에 String으로 받던 매개변수를 FoodMenu로 받음 (4번 피드백)
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
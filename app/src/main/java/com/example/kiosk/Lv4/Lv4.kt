package com.example.kiosk.Lv4

fun main() {

    val restaurant = Restaurant()
    restaurant.start()
}


open class MenuItem(val name: String, val content: String)

class FoodMenu(name: String, price: Double, content: String) : MenuItem(name, content) {
    var price: Double

    init {
        this.price = price
    }
}

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
        println("${items.size + 1}. 전 메뉴판으로 돌아가기")
    }

    fun displayFoodMenu(items: List<FoodMenu>) {
        println("원하시는 메뉴를 선택하세요")
        items.forEachIndexed { index, item ->
            println("${index + 1}. ${item.name} | ${item.price}원 : ${item.content}")
        }
        println("${items.size + 1}. 전 메뉴판으로 돌아가기")
    }
}

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

class Restaurant {
    val order = Order()
    val menu = Menu()

    fun start() {
        println("어서오세요")
        while (true) {
            menu.displayMainMenu(menu.mainMenu)
            val menuPanel = readLine()
            when (menuPanel) {
                "1" -> {
                    do {
                        menu.displayFoodMenu(menu.stakeMenuItem)
                        val stakeSelect = readLine()
                        when (stakeSelect?.toIntOrNull()) {
                            null -> {
                                order.err()
                            }

                            in 1..menu.stakeMenuItem.size -> {
                                val selectedItem = menu.stakeMenuItem[stakeSelect.toInt() - 1]
                                order.addItem(selectedItem)
                            }

                            menu.stakeMenuItem.size + 1 -> {
                                println("전 메뉴판으로 돌아갑니다")
                                break
                            }

                            else -> {
                                order.err()
                            }
                        }
                    } while (true)
                }

                "2" -> {
                    do {
                        menu.displayFoodMenu(menu.meatMenuItem)
                        val meatSelect = readLine()
                        when (meatSelect?.toIntOrNull()) {
                            null -> {
                                order.err()
                            }

                            in 1..menu.meatMenuItem.size -> {
                                val selectedItem = menu.meatMenuItem[meatSelect.toInt() - 1]
                                order.addItem(selectedItem)
                            }

                            menu.meatMenuItem.size + 1 -> {
                                println("전 메뉴판으로 돌아갑니다")
                                break
                            }

                            else -> {
                                order.err()
                            }
                        }
                    } while (true)
                }

                "3" -> {
                    do {
                        menu.displayFoodMenu(menu.drinkMenuItem)
                        val drinkSelect = readLine()
                        when (drinkSelect?.toIntOrNull()) {
                            null -> {
                                order.err()
                            }

                            in 1..menu.drinkMenuItem.size -> {
                                val selectedItem = menu.drinkMenuItem[drinkSelect.toInt() - 1]
                                order.addItem(selectedItem)
                            }

                            menu.drinkMenuItem.size + 1 -> {
                                println("전 메뉴판으로 돌아갑니다")
                                break
                            }

                            else -> {
                                order.err()
                            }
                        }
                    } while (true)
                }

                "4" -> {
                    while (true) {
                        when {
                            order.isNotEmpty() -> {
                                order.displayOrderItems()
                                println("취소할 항목을 입력하세요:")
                                println("뒤로가기를 원할 경우 숫자 0을 입력하세요")
                                val menuCancel = readLine()
                                when (menuCancel?.toIntOrNull()) {
                                    null -> {
                                        order.err()
                                    }

                                    in 1..order.items.size -> {
                                        val canceledItem = order.items[menuCancel.toInt() - 1]
                                        order.removeItem(canceledItem)

                                    }

                                    0 -> {
                                        println("전 메뉴판으로 돌아갑니다")
                                        break
                                    }

                                    else -> {
                                        println("주문 내역에 해당 항목이 없습니다.")
                                    }
                                }
                            }

                            else -> {
                                println("주문 내역이 비어 있습니다. 취소할 항목이 없습니다.")
                                break
                            }
                        }
                    }
                }

                "5" -> {
                    println("메뉴판을 종료합니다")
                    order.displayOrderItems()
                    return
                }

                else -> {
                    order.err()
                }
            }
        }
    }
}

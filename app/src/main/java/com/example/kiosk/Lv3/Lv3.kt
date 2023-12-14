package com.example.kiosk.Lv3

fun main() {
    val restaurant = Restaurant()
    restaurant.start()
}

open class MenuItem(val name: String, val price: Double, val content: String)

class Stake(name: String, price: Double, content: String) : MenuItem(name, price, content)
class Meat(name: String, price: Double, content: String) : MenuItem(name, price, content)
class Drink(name: String, price: Double, content: String) : MenuItem(name, price, content)


class Menu {
    val stakeMenuItem = listOf(
        Stake("안심", 11.9, "스테이크의 정석 안심부위"),
        Stake("등심", 10.9, "마블링이 풍부한 등심"),
        Stake("T본", 12.9, "풍부한 맛을 즐기고 싶으신분")
    )

    val meatMenuItem = listOf(
        Meat("삼겹살", 6.9, "한국인의 소울푸드"),
        Meat("목살", 5.9, "기름이 적어 담백한 그맛"),
        Meat("갈매기살", 7.9, "오늘의 특수부위")
    )

    val drinkMenuItem = listOf(
        Drink("탄산음료", 2.5, "청량감 최고"),
        Drink("맥주", 2.5, "목으로 넘어가는 시원한 한잔"),
        Drink("소주", 4.0, "삼겹살엔 소주 한잔"),
        Drink("와인", 8.9, "스테이크와 함께하는 최고의 선택")
    )

    fun mainMenu() {
        println("원하시는 메뉴를 선택하세요")
        println("1.스테이크류 | 육즙이 넘치는 스테이크!")
        println("2.구이류 | 맛있는 고기들을 한 자리에!")
        println("3.음료 및 주류 | 찰떡궁합 음료와 주류들!")
        println("4.주문 취소 | 주문 취소")
        println("5.종료 | 프로그램을 종료합니다")
    }

    fun stakeMenu() {
        displayMenuItem(stakeMenuItem)
    }

    fun meatMenu() {
        displayMenuItem(meatMenuItem)
    }

    fun drinkMenu() {
        displayMenuItem(drinkMenuItem)
    }

    fun displayMenuItem() {
        val menus : List<MenuItem>
        println("원하시는 메뉴를 선택하세요")
        //각 메뉴가 출력되게
        //근데 번호가 1 2 3 4 이런식으로 올라갈수 있게
        //ex)1.안심 2.등심 3.T본 4.전메뉴판으로 돌아가기
        //근데 음료류만 5개라서 음료류는 5번이 전메뉴판으로 가기가 되어야함...

    }

}


class Order {
    val items = ArrayList<String>()

    fun addItem(item: String) {
        println("${item} 선택 완료")
        items.add(item)
    }

    fun removeItem(item: String) {
        items.remove(item)
    }

    fun displayOrder() {
        println("주문 내역: $items")
    }

    fun isNotEmpty(): Boolean {
        return items.isNotEmpty()
    }

    fun contains(item: String): Boolean {
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
            menu.mainMenu()
            val menuPanel = readLine()
            when (menuPanel) {
                "1" -> {
                    do {
                        menu.stakeMenu()
                        val stakeSelect = readLine()
                        when (stakeSelect) {
                            "1" -> {
                                order.addItem("안심")
                            }

                            "2" -> {
                                order.addItem("등심")
                            }

                            "3" -> {
                                order.addItem("T본")
                            }

                            "4" -> {
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
                        menu.meatMenu()
                        val meatSelect = readLine()
                        when (meatSelect) {
                            "1" -> {
                                order.addItem("삼겹살")
                            }

                            "2" -> {
                                order.addItem("목살")
                            }

                            "3" -> {
                                order.addItem("갈매기살")
                            }

                            "4" -> {
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
                        menu.drinkMenu()
                        val drinkSelect = readLine()
                        when (drinkSelect) {
                            "1" -> {
                                order.addItem("탄산음료")
                            }

                            "2" -> {
                                order.addItem("맥주")
                            }

                            "3" -> {
                                order.addItem("소주")
                            }

                            "4" -> {
                                order.addItem("와인")
                            }

                            "5" -> {
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
                    while (true)
                        when {
                            order.isNotEmpty() -> {
                                println("주문 내역: ${order.items}")
                                println("취소할 항목을 입력하세요:")
                                println("뒤로가기를 원할경우 숫자 0 을 입력하세요")
                                val menuCancel = readLine().toString()
                                when {
                                    order.contains(menuCancel) -> {
                                        order.removeItem(menuCancel)
                                        println("주문 내역에서 ${menuCancel} 항목을 취소했습니다.")
                                    }

                                    menuCancel == "0" -> {
                                        println("전 메뉴판으로 돌아갑니다")
                                        break
                                    }

                                    else -> {
                                        println("주문 내역에 ${menuCancel} 항목이 없습니다.")
                                    }
                                }
                            }

                            else -> {
                                println("주문 내역이 비어 있습니다. 취소할 항목이 없습니다.")
                                break
                            }
                        }
                }

                "5" -> {
                    println("메뉴판을 종료합니다")
                    order.displayOrder()
                    return
                }

                else -> {
                    order.err()
                    continue
                }
            }
        }
    }
}
package com.example.kiosk.Lv4
//클래스 별로 파일을 나눠서 관리함(5번 피드백)
class Restaurant(val menu: Menu) {
    val order = Order()
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
package com.example.kiosk.Lv1

fun main() {
    println("어서오세요")

    while (true) {
        println("원하시는 메뉴를 선택하세요")
        println("1.스테이크류 , 2.구이류 , 3.음료 및 주류 , 4.종료")
        val menuPanel = readLine()
        when (menuPanel) {
            "1" -> {
                println("고기 부위를 선택하세요")
                println("1.안심 , 2.등심 , 3.T본 , 4.전 메뉴판으로 돌아가기")
                val stakeSelect = readLine()
                when (stakeSelect) {
                    "1" -> {
                        println("안심 선택 완료")
                        break
                    }
                    "2" -> {
                        println("등심 선택 완료")
                        break
                    }
                    "3" -> {
                        println("T본 선택 완료")
                        break
                    }
                    "4" ->  {
                        println("전 메뉴판으로 돌아갑니다")
                        return main()
                    }
                    else -> {
                        System.err.println("다시 올바른 번호를 입력해주세요")
                        continue
                    }

                }

            }
            "2" -> {
                println("구위 부위를 선택하세요")
                println("1.삼겹살 , 2.목살 , 3.갈매기살 , 4.전 메뉴판으로 돌아가기")
                val meatSelect = readLine()
                when (meatSelect) {
                    "1" -> {
                        println("삼겹살 선택 완료")
                        break
                    }
                    "2" -> {
                        println("목살 선택 완료")
                        break
                    }
                    "3" -> {
                        println("갈매기살 선택 완료")
                        break
                    }
                    "4" ->  {
                        println("전 메뉴판으로 돌아갑니다")
                        return main()
                    }
                    else -> {
                        System.err.println("다시 올바른 번호를 입력해주세요")
                        continue
                    }

                }
            }

            "3" -> {
                println("음료 및 주류를 선택하세요")
                println("1.탄산음료 , 2.맥주 , 3.소주 , 4.와인 , 5.전 메뉴판으로 돌아가기")
                val drinkSelect = readLine()
                when (drinkSelect) {
                    "1" -> {
                        println("탄산음료 선택 완료")
                        break
                    }
                    "2" -> {
                        println("맥주 선택 완료")
                        break
                    }
                    "3" -> {
                        println("소주 선택 완료")
                        break
                    }
                    "4" -> {
                        println("와인 선택 완료")
                        break
                    }
                    "5" ->  {
                        println("전 메뉴판으로 돌아갑니다")
                        return main()
                    }
                    else -> {
                        System.err.println("다시 올바른 번호를 입력해주세요")
                        continue
                    }

                }

            }

            "4" -> {
                println("메뉴판을 종료합니다")
                return
            }
            else -> {
                System.err.println("다시 올바른 번호를 입력해주세요")
                continue
            }
        }

    }
}

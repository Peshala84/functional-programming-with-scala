object question04{
    def main(args: Array[String]): Unit={
        println(s"Ticket Price     Profit")
        println(s"5                ${profit(5)}")
        println(s"10               ${profit(10)}")
        println(s"15               ${profit(15)}")
        println(s"20               ${profit(20)}")
        println(s"25               ${profit(25)}")
        println(s"30               ${profit(30)}")
        println ("\n")
        println(s"Best profitable ticket price: ${bestPrice()}")
    }

    def attendees(ticket_price:Double):Int={
        120 + ((15 - ticket_price)/5 * 20).toInt
    }

    def revenue(ticket_price:Double)={
        attendees(ticket_price) * ticket_price
    }

    def cost(ticket_price:Double)={                   
        500 + 3*attendees(ticket_price)
    }

    def profit(ticket_price:Double)={
        revenue(ticket_price) - cost(ticket_price)
    }

    def bestPrice(): Double = {
        var ticket_price = 5.0
        var maxProfit = profit(ticket_price)
        var bestPrice = ticket_price

        while (attendees(ticket_price) >= 0) {
            val currentProfit = profit(ticket_price)
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit
                bestPrice = ticket_price
            }
            ticket_price += 5.0
        }

        bestPrice
    }

}
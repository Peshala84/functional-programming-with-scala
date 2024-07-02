object que_03{
    
    def Average(num1: Int , num2: Int):Double={
        val avg = (num1+num2)/2.0
        BigDecimal(avg).setScale(2 , BigDecimal.RoundingMode.HALF_UP).toDouble
    }
    def main(args: Array[String]):Unit={
        var mean = Average(10 , 25)
        println(f"Average of 10 and 25 is $mean%.2f")
    }
}
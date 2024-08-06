object calculateSqu {
    def main(arg: Array[String]): Unit = {
        val number1 :List[Int] = List(1,2,3,4,5);
        println(s"Input ${number1.mkString(",")}");
        val number2 = calculateSquare(number1);
        println(s"Output ${number2.mkString(",")}");
    }

    def calculateSquare(num : List[Int]): List[Int] = {
        val num1 : List[Int] = num.map(x => x*x);
        num1; 
    }
}

object filterPrimeNumber {
    def main (args:Array[String]): Unit = {
        val num1 : List[Int] = List(1,2,3,4,5,6,7,8,9,10);
        println(s"Input ${num1.mkString(",")}");
        val num2 = filterPrime (num1);
        println(s"Output ${num2.mkString(",")}");
    }

    def filterPrime (number : List[Int]): List[Int] = {
        val num3 : List[Int] = number.filter(n => {
            if (n <= 1) false
            else !((2 until n).exists(i => n % i == 0))
        })
        num3;
    }
}
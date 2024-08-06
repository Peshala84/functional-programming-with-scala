object filterEvenNum {
    def main(arg: Array[String]): Unit = {
        val numPre : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        println(s"Input : [${numPre.mkString(", ")}]");
        val numbers = filterEvenNumbers(numPre);
        println(s"Output : [${numbers.mkString(", ")}]");
    }

    def filterEvenNumbers(num : List[Int]): List[Int] = {
        val evenNumbers : List[Int] = num.filter(x => x%2 == 0)
        evenNumbers;
    }
}
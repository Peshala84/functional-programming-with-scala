object FibonacciSequence {

  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }


  def printFibonacciHelper(current: Int, n: Int): Unit = {
    if (current < n) {
      print(s"${fibonacci(current)} ")
      printFibonacciHelper(current + 1, n)
    } else {
      println() 
    }
  }

 
  def printFibonacci(n: Int): Unit = {
    printFibonacciHelper(0, n)
  }

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine("Enter the number of Fibonacci numbers to print: ").toInt
    println(s"The first $n Fibonacci numbers are:")
    printFibonacci(n)
  }
}

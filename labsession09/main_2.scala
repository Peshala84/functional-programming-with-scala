object PatternMatching extends App {
  if (args.length > 0) {
    val input = args(0).toInt

    val result: Int => String = {
      case n if n <= 0 => "Negative/Zero is input"
      case n if n % 2 == 0 => "Even number is given"
      case _ => "Odd number is given"
    }

    println(result(input))
  } else {
    println("Please provide an integer input.")
  }
}

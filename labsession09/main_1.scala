object InterestCalculator extends App {
  val calculateInterest: Double => Double = (deposit) => deposit match {
    case d if d <= 20000 => d * 0.02
    case d if d <= 200000 => d * 0.04
    case d if d <= 2000000 => d * 0.035
    case d if d > 200000 => d * 0.065
  }

  // Example Usage
  println(calculateInterest(10000))    // Output: 200.0
  println(calculateInterest(150000))   // Output: 6000.0
  println(calculateInterest(500000))   // Output: 17500.0
  println(calculateInterest(3000000))  // Output: 195000.0
}

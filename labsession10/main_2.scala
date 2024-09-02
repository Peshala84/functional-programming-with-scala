class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator must be non-zero")

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1) // Auxiliary constructor for whole numbers

  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def -(that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def neg: Rational = new Rational(-numer, denom)
  
  def sub(that: Rational): Rational = this - that

  override def toString: String = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

object Rational {
  def apply(n: Int, d: Int) = new Rational(n, d)
  def apply(n: Int) = new Rational(n)
}

// Usage example
object Main extends App {
  val x = Rational(3, 4)
  val y = Rational(5, 8)
  val z = Rational(2, 7)

  val result = x * (y sub z)
  println(s"Result of x * (y - z): $result")
}
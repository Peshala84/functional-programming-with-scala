object que_01 {
  def reverseString(string: String): String = {
    if (string.isEmpty) ""
    else reverseString(string.tail) + string.head
  }

  def main(args: Array[String]): Unit = {
    var string = "Ramesh Peshala"
    var reversed_string = reverseString(string)
    println(reversed_string)
  }
}
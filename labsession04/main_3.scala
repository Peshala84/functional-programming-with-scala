object StringFormatter {
  def toUpper(str: String): String = {
    str.toUpperCase()
  }

  def toLower(str: String): String = {
    str.toLowerCase()
  }

  def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
  }

  def main(args: Array[String]): Unit = {
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    // Applying different formats
    val formattedNames = names.map {
      case "Benny" => formatNames("Benny")(toUpper)
      case "Niroshan" => formatNames("Niroshan")(name => name.substring(0, 2).toUpperCase + name.substring(2).toLowerCase)
      case "Saman" => formatNames("Saman")(toLower)
      case "Kumara" => formatNames("Kumara")(name => name.substring(0, 1).toUpperCase + name.substring(1, name.length - 1).toLowerCase + name.substring(name.length - 1).toUpperCase)
    }

    formattedNames.foreach(println)
  }
}

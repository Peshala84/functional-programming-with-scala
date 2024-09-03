object LetterCounter {
  def countLetterOccurrences(words: List[String]): Int = {
    val lengths = words.map(_.length)      // Step 1: Map words to their lengths
    val totalLetters = lengths.reduce(_ + _) // Step 2: Reduce lengths to get total letter count
    totalLetters
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val totalCount = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $totalCount")
  }
}

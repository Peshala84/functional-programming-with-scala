import scala.io.StdIn.readLine

object LibraryManagement {

  case class Book(title: String, author: String, isbn: String)

  
  var library: Set[Book] = Set(
    Book("To Kill a Mockingbird", "Harper Lee", "1234567890"),
    Book("1984", "George Orwell", "0987654321"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "1122334455")
  )

  
  def addBook(book: Book): Unit = {
    library += book
    println(s"Book '${book.title}' added to the library.")
  }

  def removeBookByIsbn(isbn: String): Unit = {
    val bookOpt = library.find(_.isbn == isbn)
    bookOpt match {
      case Some(book) =>
        library -= book
        println(s"Book '${book.title}' removed from the library.")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibraryCollection(): Unit = {
    println("\nLibrary Collection:")
    library.foreach { book =>
      println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    }
  }

  def searchBookByTitle(title: String): Unit = {
    val bookOpt = library.find(_.title.equalsIgnoreCase(title))
    bookOpt match {
      case Some(book) =>
        println(s"\nBook Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"\nNo book found with title: $title")
    }
  }

  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"\nBooks by $author:")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    } else {
      println(s"\nNo books found by author: $author")
    }
  }

  def main(args: Array[String]): Unit = {
    var continue = true
    while (continue) {
      println(
        """
          |Select an option:
          |1. Add a new book
          |2. Remove a book by ISBN
          |3. Check if a book is in the library by ISBN
          |4. Display the current library collection
          |5. Search for a book by title
          |6. Display all books by a specific author
          |7. Exit
          |""".stripMargin
      )
      val choice = readLine("Enter your choice: ")

      choice match {
        case "1" =>
          val title = readLine("Enter book title: ")
          val author = readLine("Enter book author: ")
          val isbn = readLine("Enter book ISBN: ")
          addBook(Book(title, author, isbn))
        case "2" =>
          val isbn = readLine("Enter book ISBN to remove: ")
          removeBookByIsbn(isbn)
        case "3" =>
          val isbn = readLine("Enter book ISBN to check: ")
          println(s"\nIs book with ISBN '$isbn' in the library? ${isBookInLibrary(isbn)}")
        case "4" =>
          displayLibraryCollection()
        case "5" =>
          val title = readLine("Enter book title to search: ")
          searchBookByTitle(title)
        case "6" =>
          val author = readLine("Enter author to list books: ")
          displayBooksByAuthor(author)
        case "7" =>
          continue = false
        case _ =>
          println("Invalid choice. Please try again.")
      }
    }
  }
}

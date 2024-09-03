// Define a class for Account
class Account(val id: String, var balance: Double) {
  override def toString: String = s"Account($id, Balance: $$balance)"
}

// Define the Bank as a List of Accounts
object Bank {
  type Bank = List[Account]

  // 4.1 List of Accounts with negative balances
  def negativeBalances(bank: Bank): List[Account] = {
    bank.filter(_.balance < 0)
  }

  // 4.2 Calculate the sum of all account balances
  def totalBalance(bank: Bank): Double = {
    bank.map(_.balance).sum
  }

  // 4.3 Calculate the final balances of all accounts after applying the interest function
  def applyInterest(bank: Bank): Bank = {
    bank.map { account =>
      if (account.balance > 0) {
        account.balance += account.balance * 0.05
      } else {
        account.balance += account.balance * 0.1
      }
      account
    }
  }
}

// Example usage
object BankApp extends App {
  val accounts = List(
    new Account("A1", 500.0),
    new Account("A2", -150.0),
    new Account("A3", 0.0),
    new Account("A4", -75.0),
    new Account("A5", 1000.0)
  )

  println("Accounts with negative balances:")
  Bank.negativeBalances(accounts).foreach(println)

  println(s"Total balance in the bank: ${Bank.totalBalance(accounts)}")

  println("Final balances after applying interest:")
  Bank.applyInterest(accounts).foreach(println)
}

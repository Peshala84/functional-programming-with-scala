class Account(var balance: Double) {
  require(balance >= 0, "Initial balance must be non-negative")

  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
    println(s"Deposited $$amount. New balance: $$balance")
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdraw amount must be positive")
    if (amount <= balance) {
      balance -= amount
      println(s"Withdrew $$amount. New balance: $$balance")
    } else {
      println(s"Insufficient funds. Current balance: $$balance")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $$amount to account with new balance: $${toAccount.balance}")
    } else {
      println(s"Insufficient funds to transfer. Current balance: $$balance")
    }
  }

  override def toString: String = s"Account(balance: $$balance)"
}

class Bank(val accounts: List[Account]) {
  def accountsWithNegativeBalances: List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def totalBalance: Double = {
    accounts.map(_.balance).sum
  }

  def applyInterest(): Unit = {
    accounts.foreach { account =>
      if (account.balance > 0) {
        account.deposit(account.balance * 0.05)
      } else if (account.balance < 0) {
        account.withdraw(account.balance * -0.1) // Overdraft interest is deducted
      }
    }
  }

  override def toString: String = accounts.mkString(", ")
}

// Usage example
object Main extends App {
  val account1 = new Account(1000.0)
  val account2 = new Account(-50.0)
  val account3 = new Account(500.0)
  val account4 = new Account(-200.0)

  val bank = new Bank(List(account1, account2, account3, account4))

  println(s"Accounts with negative balances: ${bank.accountsWithNegativeBalances}")
  println(s"Total balance of all accounts: $$${bank.totalBalance}")

  bank.applyInterest()

  println(s"Final balances after applying interest: $bank")
}
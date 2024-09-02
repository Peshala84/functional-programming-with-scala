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

// Usage example
object Main extends App {
  val account1 = new Account(1000.0)
  val account2 = new Account(500.0)

  println(s"Initial balance of account1: $$${account1.balance}")
  println(s"Initial balance of account2: $$${account2.balance}")

  account1.deposit(200.0)
  account1.withdraw(150.0)

  account1.transfer(300.0, account2)

  println(s"Final balance of account1: $$${account1.balance}")
  println(s"Final balance of account2: $$${account2.balance}")
}
object InventoryManagement {

  var itemNames: Array[String] = Array.empty[String]
  var itemQuantities: Array[Int] = Array.empty[Int]

  // Function to display inventory
  def displayInventory(): Unit = {
    if (itemNames.isEmpty) {
      println("Inventory is empty.")
    } else {
      println("Inventory:")
      for (i <- itemNames.indices) {
        println(s"${itemNames(i)}: ${itemQuantities(i)}")
      }
    }
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
  val index = itemNames.indexOf(itemName)
  if (index >= 0) {
    itemQuantities(index) += quantity
    println(s"Added $quantity more of $itemName (Total: ${itemQuantities(index)})")
  } else {
    itemNames = itemNames :+ itemName // Add new item name
    itemQuantities = itemQuantities :+ quantity // Add corresponding quantity
    println(s"Added $quantity of new item: $itemName")
  }
}


  // Function to sell item
  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index >= 0) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"Sold $quantity of $itemName")
      } else {
        println(s"Insufficient quantity of $itemName. Only ${itemQuantities(index)} available.")
      }
    } else {
      println(s"Item '$itemName' not found in inventory.")
    }
  }

  def main(args: Array[String]): Unit = {
  restockItem("Book", 10)
  restockItem("Pen", 5)

  displayInventory() // Display updated inventory

  sellItem("Book", 3)
  sellItem("Pen", 2) // Item not found

  displayInventory() // Display inventory after selling
}

}

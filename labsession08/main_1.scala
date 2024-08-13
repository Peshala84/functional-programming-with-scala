object CaesarCiper {

    def Encrypt(shift:Int,text:String): String ={
    val newText = new StringBuilder
    val normalizedShift = shift % 26 
    for (i <- 0 until text.length) {
      val value = text(i).toInt
      val newChar = if (value >= 65 && value <= 90) { // Uppercase
                        ((value - 65 + normalizedShift + 26) % 26 + 65).toChar
                    }
                    else if (value >= 97 && value <= 122) { // Lowercase
                        ((value - 97 + normalizedShift + 26) % 26 + 97).toChar
                    } else { // Non-alphabetic characters
                        text(i)
                    }
      newText.append(newChar)
    }
    newText.toString()
    }

    def Decrypt(shift:Int,text:String): String = {
    val normalizedShift = shift % 26 
    val newText = new StringBuilder
    for (i <- 0 until text.length) {
      val value = text(i).toInt;
      val newChar = if (value >= 65 && value <= 90) { // Uppercase
        ((value - 65 - normalizedShift + 26) % 26 + 65).toChar
      } else if (value >= 97 && value <= 122) { // Lowercase
        ((value - 97 - normalizedShift + 26) % 26 + 97).toChar
      } else { // Non-alphabetic characters
        text(i)
      }
      newText.append(newChar)
    }
    newText.toString()
    }

    def main(arg: Array[String]) : Unit = {
        val shift = 3;
        val text = "Ramesh";
        println(s"The text is $text");
        // String after encryption
        val newString = Encrypt(shift,text); 
        println(s"The text after encryption is $newString");
        // String after decryption
        val newString1 = Decrypt(shift,newString);
        println(s"the text after decryption is $newString1");
    } 

}
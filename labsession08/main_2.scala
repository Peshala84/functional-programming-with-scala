import scala.io.StdIn

object  Multiples{

    def main(arg : Array[String]): Unit ={

        println("Enter the Number : ");
        val Number = StdIn.readInt();

        val isMultipleOf3 = (n: Int) => n % 3 == 0
        val isMultipleOf5 = (n: Int) => n % 5 == 0

        if (isMultipleOf3(Number) && isMultipleOf5(Number)) {
            println("Multiple of Both Three and Five");

        }
        else if (isMultipleOf3(Number)) {
            println("Multiple of Three");
        }
        else if (isMultipleOf5(Number)) {
            println("Multiple of Five");
        }
        else {
            println("Not a Multiple of Three or Five");
        }
    }
}
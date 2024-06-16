object main_2 {
    def celcius_to_fahrenheit(cels:Double): Double = {
        return cels* 1.8 + 32;

    }
    var cels= 35.0;
    var fahr=celcius_to_fahrenheit(cels);
    println(fahr);
}
package assignment_module_2

/**
  * Created by Mukut on 5/16/2017.
  */
object GCD {

    def gcd(x: Int,y: Int): Int = {
      var a = x;
      var b = y;
      while(a != 0){
        val gcd = a;
        a = b%a;
        b = gcd;
      }
      return b;
    }

    def main(args: Array[String]) {
      println(gcd(25,15))
    }


}

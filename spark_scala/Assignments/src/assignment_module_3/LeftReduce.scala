package assignment_module_3

/**
  * Created by Mukut on 5/18/2017.
  */
object LeftReduce {
  def main(args: Array[String]): Unit = {
    var input = Array(1,2,3,4,5,6,7,8,9);
    println(input.reduceLeft(_+_));
  }

}

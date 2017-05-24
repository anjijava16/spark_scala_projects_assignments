package assignment_module_2

/**
  * Created by Mukut on 5/16/2017.
  */
object ListFilter {

  def main(args: Array[String]): Unit = {
    val input = List(1,2,3,4,5,6,7,8,9,0);
    val even = input.filter(x => (x%2 == 0));
    val odd = input.filter(x => (x%2 != 0));
    even.foreach(println);
    odd.foreach(println);

  }
}
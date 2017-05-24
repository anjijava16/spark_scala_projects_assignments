package assignment_module_2

/**
  * Created by Mukut on 5/13/2017.
  */
object wordCount {
  def main(args: Array[String]): Unit = {
    val input = args(0);
    val words = input.split(" ");
    print(words.length);
  }
}

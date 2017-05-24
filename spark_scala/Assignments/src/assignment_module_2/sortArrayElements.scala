package assignment_module_2

import scala.util.Sorting

/**
  * Created by Mukut on 5/13/2017.
  */
object sortArrayElements {

  def main(args: Array[String]): Unit = {
    val array = Array(1,5,2,6,3,1,9,5,7,8);
    print("Unsorted array: "+ array.mkString(" ") );
    Sorting.quickSort(array);
    print("sortedArray: "+array.mkString(" ") );
  }

}

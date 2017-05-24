package assignment_module_2

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Mukut on 5/17/2017.
  */
object MergeArrays {

  def main(args: Array[String]): Unit = {

    var arrayBuffer = ArrayBuffer[String]();
    var cars = Array("maruti","honda", "toyota");
    var superCars = Array("BMW","MERCEDES","PORCHE");
    arrayBuffer++=cars;
    arrayBuffer++=superCars;
    arrayBuffer.foreach(println);
  }


}

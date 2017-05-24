package assignment_module_3

/**
  * Created by Mukut on 5/17/2017.
  */
object MapOperations {

  def main(args: Array[String]): Unit = {
    var map = Map("IN" -> "India","UK"->"United Kingdom","USA"->"United States of America", "UAE" -> "United Arab Emirates");
    println("---------INITIAL MAP---------")

    map.foreach(println);
    println("----------------------------------")
    //remove keys from the map
    map-="IN";
    map-="UK";
    map.foreach(println);
    println("----------------------------------")

    //add new key and value
    map+="JP"->"JAPAN";
    map.foreach(println);


  }

}

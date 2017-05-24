import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mukut on 5/23/2017.
  */
object MergeRDD {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("word finder")setMaster("local[*]"))
    val input = sc.textFile("./src/main/resources/sample1.txt");
    val x = sc.parallelize(List(("Hello", 1), ("World", 4),("Scala",3)))
    val y = sc.parallelize(List(("Hello", 2), ("Hello", 3),("World",2)))
    x.join(y).collect().foreach(println)
  }

}

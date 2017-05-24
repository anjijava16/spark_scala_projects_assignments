import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mukut on 5/23/2017.
  */
object WordCount {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("word finder") setMaster ("local[*]"))
    val input = sc.textFile("./src/main/resources/sample");
    val word = input.flatMap(l => l.split(" ")).map(x => (x, 1)).reduceByKey(_ + _);
    println(word.count())
    word.foreach(println);
  }
}
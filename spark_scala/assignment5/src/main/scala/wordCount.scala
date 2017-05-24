import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mukut on 5/23/2017.
  */
object wordCount {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("wordCount").setMaster("local[*]"));
    val input = sc.textFile("./src/main/resources/sample.txt").cache()
    val totalWords = input.flatMap(l => l.split(" ")).count();
    println("Total number of words including duplicates: "+totalWords)
    val wordCount = input.flatMap(lines => lines.split(" ")).map(x => (x,1)).reduceByKey(_+_).count();
    println("WordCount: "+wordCount)
  }
}

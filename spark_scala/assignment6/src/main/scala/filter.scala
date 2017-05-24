import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mukut on 5/23/2017.
  */
object filter {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("word finder")setMaster("local[*]"))
    val input = sc.textFile("./src/main/resources/sample1.txt");
    val spark =input.filter(lines  =>  {lines.split(" ") contains "Spark"}).count()
    print(spark)
  }

}

/**
  * Created by Mukut on 5/23/2017.
  */
import org.apache.spark.{SparkConf, SparkContext};

object logAnalysis {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Log Analyser").setMaster("local[*]");
    val sc = new SparkContext(conf);
    val input = sc.textFile("D:\\spark_scala\\Logs.txt").cache()
    val errorCount = input.filter(line => line.contains("[error]")).count();
    println("Error count in the log is: "+ errorCount)
  }

}

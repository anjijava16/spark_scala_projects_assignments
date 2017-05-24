import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._
import org.apache.spark.sql.functions._
/**
  * Created by Mukut on 5/23/2017.
  */
object employeeAnalysis {

  case class Employee(id:Int, name:String, salary:Int, department: String)

  def main(args: Array[String]): Unit = {
    println("calculate maximum salary")
    val sc = new SparkContext(new SparkConf().setAppName("wordCount").setMaster("local[*]"));
    val sqlContext = new SQLContext(sc);
    val input = sc.textFile("./src/main/resources/emp").cache()
    val data = input.map(x => x.split(",")).map(e => Employee(e(0).toInt, e(1), e(2).toInt, e(3)))
    val employeeDf = sqlContext.createDataFrame(data)
    println("Maximum salary")
    employeeDf.sort(desc("salary")).show()
  }

}

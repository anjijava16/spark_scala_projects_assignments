import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD._
import org.apache.spark.sql.functions._

import scala.collection.mutable

/**
  * Created by Mukut on 5/23/2017.
  */
object SportsAnalysis {

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("Sports Analysis").setMaster("local[*]"))
    val sqlContext = new org.apache.spark.sql.SQLContext(sc);
    val dataset = sc.textFile("./src/main/resources/olympic_medalists_dataset.csv")


    var data = new mutable.ArrayBuffer[StructField];
    data += StructField("city",StringType,true)
    data += (StructField("year",IntegerType,true))
    data += (StructField("sport_type",StringType,true))
    data += (StructField("discipline",StringType,true))
    data += (StructField("athlete",StringType,true))
    data += (StructField("country_code",StringType,true))
    data += (StructField("gender",StringType,true))
    data += (StructField("event",StringType,true))
    data += (StructField("m",StringType,true))
    data += (StructField("medal",StringType,true))


    val schema = StructType(data)
    val rowRDD = dataset.map(_.split(",")).map(p => Row(p(0), p(1).toInt,p(2),p(3),p(4),p(5),p(6),p(7),p(8),p(9)))

    val dataFrame = sqlContext.createDataFrame(rowRDD, schema)

    dataFrame.registerTempTable("olympics")


    val athletesBeijing  = dataFrame.filter(col("city") ==="Beijing").count()
    val atheletsFromBejingWhoWonGoldMedal = dataFrame.filter(col("city") ==="Beijing" && col("medal")==="Gold").count()

    //Find out what percentage of athletes from “Beijing” appeared in Olympics of 2008, won gold medals irrespective of the type of the evens
    println("percetage :"+((atheletsFromBejingWhoWonGoldMedal*1.0/athletesBeijing*1.0) *100))

    //Find the athlete name, who has won highest number of gold
    val athlete = dataFrame.map(t => (t(4),1)).reduceByKey(_ + _ ).reduce((a,b) => (if (a._2>b._2) a else b) )


   //list the years in which he appeared in Olympics
    dataFrame.filter(col("athlete") === athlete._1).select(col("year")).distinct.show()
    val indians =dataFrame.filter(col("year") >1900 &&  col("year")<1948 && col("country_code") === "IND")
    //Indians who won gold in between 1900 to 1948?
    indians.show()
  }
}

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.functions._
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mukut on 5/23/2017.
  */
object actorAnalysis {

  case class ActorDetail(id:Int, actorName:String, genre:String, noOfMovies:Int, hits:Int)

  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("Actor analysis").setMaster("local[*]"));
    val sqLContext = new SQLContext(sc)
    val data = "1001,Johnny Lever,Commedian,210,190\n" +
      "1002,Amit Mahesh,New Comer,2,1\n" +
      "1003,Salman Khan,SuperStar,300,291\n" +
      "1004,Johnny Depp,SuperStar,289,270\n" +
      "1005,Mallika Sherawat,Actress,20,10\n" +
      "1006,Amitabh Bachan,SuperStar,350,300\n" +
      "1007,Micheal Bijlu,New Comer,4,1\n" +
      "1008,Rocky Angelo,New Comer,3,1\n" +
      "1009,Rajani Kanth,SuperStar,400,399\n" +
      "1010,Arnold,SuperStar,261,242"

    // construct the dataset as given below using Seq and case class ActorDetail
    val actorDetail = data.split("\n").map(line => {
      val l = line.split(",")
      ActorDetail(l(0).toInt, l(1), l(2), l(3).toInt, l(4).toInt)
    })

    //Construct a data frame using the above dataset by creating 2 partitions
    val actorRDD = sc.parallelize( actorDetail,2)

    val actorDF = sqLContext.createDataFrame(actorRDD);

    //Show the all the details of the actDetailsDF and also show only the first two records of
    //the actorDetails dataset
    actorDF.collect().foreach(println)

    actorDF.take(2).foreach(println)

    //print schema
    actorDF.printSchema()

    //Register the DataFrame as temp table and only select the rows for whom the no of hits are
    //more than 250 and print the output.
    actorDF.registerTempTable("actors")
    println("2. Calculate Maxsalary")
    sqLContext.sql("SELECT MAX(hits) as MaxHits from actors").show()
  }

}

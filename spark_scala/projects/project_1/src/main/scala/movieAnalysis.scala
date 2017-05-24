import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Mukut on 5/23/2017.
  */
object movieAnalysis {

  //create case class
  case class Movie(year: Int, length: Int, title:String, subject:String, actor:String, actress: String, director:String, popularity:Int, award:String)


  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setMaster("local[*]").setAppName("movie analysis"))
    val input = sc.textFile("./src/main/resources/movies_dataset.csv")
    val sqLContext = new SQLContext(sc);

    import sqLContext.implicits._

    //create RDD
    val movieRDD = input.map(x => x.split(",")).map(m => Movie(m(0).toInt, m(1).toInt, m(2),m(3),m(4),m(5),m(6),m(7).toInt,m(8)))

    //create dataframe from RDD
    val movieDF = movieRDD.toDF()

    //Q1: How many horror movies were there between the year 1952 and 1968?
    val horrorMovies = movieDF.filter($"year" > 1952 && $"year" < 1968 && $"subject" === "Horror")


    //Q2: How many movies were released for each year?
    movieDF.groupBy("year")


    //q3: How many movie’s length greater than 100 min?
    movieDF.filter($"length">100).count()


    //q4: List the awarded movie director names and title
    val awarded = movieDF.filter($"award"==="Yes")
    awarded.select(movieDF("Director"),movieDF("Actor")).show()

    //q5: Find the name of the actor who have worked more than 1 movie
    val actor = movieDF.groupBy("Actor").count().filter($"count">1).show()

    //q6: List the title of the movies whose popularity reach above 60
    movieDF.filter($"popularity">60).show()
  }

}

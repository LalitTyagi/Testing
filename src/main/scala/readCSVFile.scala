import java.io.File
import java.sql._
import java.util.Properties
//import com.typesafe.config.ConfigFactory
import org.apache.spark.sql.SparkSession
import scala.collection.mutable.ListBuffer
import scala.io.Source.fromFile

object readCSVFile extends App {
  //reading values from the csv_files for the table names for mysql//
  var csv_read = new ListBuffer[String]()
  val bufferedSource = fromFile("src/main/resource/data.csv")
  for (line <- bufferedSource.getLines) {
    val cols = line.split(",").map(_.trim)
    println(s"${cols(0)}|${cols(1)}|${cols(2)}")
//    csv_read += {
//      cols(0)
//    }
  }
  bufferedSource.close
 // println(csv_read)
 // val con_list = csv_read.toList
}

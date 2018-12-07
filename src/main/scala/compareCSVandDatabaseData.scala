import java.sql.DriverManager
import java.sql.Connection
import java.io.File
import java.sql._
import java.util.Properties
import org.apache.spark.sql.SparkSession
import scala.collection.mutable.ListBuffer
import scala.io.Source.fromFile


object compareCSVandDatabaseData extends App {
  val driver = "com.mysql.jdbc.Driver"
  val url = "jdbc:mysql://localhost:3306/testDB?autoReconnect=true&useSSL=false"
  val username = "root"
  val password = "root"
  var countDB = 0
  var countCSV = 0

  // there's probably a better way to do this
  var connection:Connection = _


    // make the connection
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password )
    println("Connection with DB")

    // create the statement, and run the select query
    val statement = connection.createStatement()
    val resultSet = statement.executeQuery("SELECT ID, name FROM Highschooler")
    while ( resultSet.next() ) {
//      val ID = resultSet.getString("ID")
//      val name = resultSet.getString("name")
//      println("ID = %s, name = %s".format(ID,name))
        countDB +=1
    }
    connection.close()

  var csv_read = new ListBuffer[String]()
  val bufferedSource = fromFile("src/main/resource/data.csv")
  for (line <- bufferedSource.getLines) {
    val cols = line.split(",").map(_.trim)
    countCSV+=1
  }
  bufferedSource.close()
  println(countDB)
  println(countCSV)
}

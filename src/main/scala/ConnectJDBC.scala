import java.sql.DriverManager
import java.sql.Connection


object ConnectJDBC {
  def main(args: Array[String]) {
    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost:3306/testDB?autoReconnect=true&useSSL=false"
    val username = "root"
    val password = "root"

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password )
      println("Connection")

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT ID, name FROM Highschooler")
      while ( resultSet.next() ) {
        val ID = resultSet.getString("ID")
        val name = resultSet.getString("name")
        println("ID = %s, name = %s".format(ID,name))
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
  }
}
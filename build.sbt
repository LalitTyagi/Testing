name := "Testing"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.46"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.1",
  "org.apache.spark" %% "spark-sql" % "2.1.1",
  "org.apache.spark" %% "spark-mllib" % "2.1.0",
  "com.databricks" %% "spark-csv" % "1.5.0",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.xerial" % "sqlite-jdbc" % " 3.7.2 "
)



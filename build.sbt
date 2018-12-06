name := "Testing"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.46"

val sparkVersion = "2.1.1"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)



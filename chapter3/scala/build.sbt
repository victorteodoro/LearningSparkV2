//name of the package
// To build simply type `sbt clean package`
name := "main/scala/chapter3"
//version of our package
version := "1.0"

//version of Scala
scalaVersion := "2.13.12"

val sparkVersion = "3.5.0"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

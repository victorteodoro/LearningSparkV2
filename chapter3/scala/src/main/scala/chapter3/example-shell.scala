import org.apache.spark.sql.types._
import org.apache.spark.sql.functions.{col, expr}

// get the path to the JSON file
val jsonFile = "../../../../data/blogs.json"
// define our schema as before
val schema = StructType(
  Array(
    StructField("Id", IntegerType, false),
    StructField("First", StringType, false),
    StructField("Last", StringType, false),
    StructField("Url", StringType, false),
    StructField("Published", StringType, false),
    StructField("Hits", IntegerType, false),
    StructField("Campaigns", ArrayType(StringType), false)
  )
)

// Create a DataFrame by reading from the JSON file a predefined Schema
val blogsDF = spark.read.schema(schema).json(jsonFile)
// show the DataFrame schema as output
blogsDF.show(truncate = false)
// print the schemas
// println(blogsDF.printSchema)
println(blogsDF.schema)
// Show columns and expressions
blogsDF.select(expr("Hits") * 2).show(2)
blogsDF.select(col("Hits") * 2).show(2)
blogsDF.select(expr("Hits * 2")).show(2)
// show heavy hitters
blogsDF.withColumn("Big Hitters", (expr("Hits > 10000"))).show()

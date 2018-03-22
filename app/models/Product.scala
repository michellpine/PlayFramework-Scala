package models

import MongoFactory.MongoFactory
import com.mongodb.casbah.Imports._

import scala.collection.mutable.ListBuffer

//model class
case class Product(ean: Long, name: String, description: String)

// Data Access Object
object Product {
  /*Convert a Product object into a BSON format that
  MongoDB can store
   */
  val collection = MongoFactory.collection

  Product.add( Product(123456789001L, "Paperclips Large", "Large Plain Pack of 100"))
  Product.add( Product(123456789002L, "Giant Paperclips", "Giant Plain 51mm 100 pack"))
  Product.add( Product(123456789003L, "Paperclip Giant Plain", "Giant Plain Pack of 1000"))
  Product.add( Product(123456789004L, "No Tear Paper Clip", "No tear extra large pack 1000"))
  Product.add( Product(123456789005L, "Zebra Paperclips", "Zebra Length 28mm Assorted 150 pack"))

  def convertDbObjectToProduct(obj: MongoDBObject): Product = {
    val ean = obj.getAs[Long]("ean").get
    val name = obj.getAs[String]("name").get
    val description = obj.getAs[String]("description").get
    Product(ean, name, description)
  }

  def buildMongoDbObject(product: Product): MongoDBObject = {
    val builder = MongoDBObject.newBuilder
    builder += "ean" -> product.ean
    builder += "name" -> product.name
    builder += "description" -> product.description
    builder.result()
  }

  def add(product: Product){
    val mongoObj = buildMongoDbObject(product)
    MongoFactory.collection.save(mongoObj)
  }

  def findByEan(ean: Long): Product = {
    val result = collection.findOne(MongoDBObject("ean" -> ean))
    convertDbObjectToProduct(result.get)
  }

  def findAll() = {
    val result = collection.find
    result.map( l => toProduct(l) ).toList
  }

  def toProduct(dbObject:DBObject) : Product = {
    Product(
      dbObject.as[Long]("ean"),
      dbObject.as[String]("name"),
      dbObject.as[String]("description")
    )
  }

}

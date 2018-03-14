package models

import play.api.data.Form._

//model class
case class Product(ean: Long, name: String, description: String)

// Data Access Object
object Product {
  var products = Set (
    Product(123456789001L, "Paperclips Large", "Large Plain Pack of 100"),
    Product(123456789002L, "Giant Paperclips", "Giant Plain 51mm 100 pack"),
    Product(123456789003L, "Paperclip Giant Plain", "Giant Plain Pack of 1000"),
    Product(123456789004L, "No Tear Paper Clip", "No tear extra large pack 1000"),
    Product(123456789005L, "Zebra Paperclips", "Zebra Length 28mm Assorted 150 pack")
  )

  def findAll = products.toList.sortBy(_.ean)

  def findByEan(ean: Long) = products.find(_.ean == ean)

  def add(product: Product){
    products = products + product
  }
}
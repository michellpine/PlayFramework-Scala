package models

//model class
case class Product(ean: Long, name: String, description: String)

// Data Access Object
object Product {
  var products = Set (
    Product(123L, "Paperclips Large", "Large Plain Pack of 100"),
    Product(124L, "Giant Paperclips", "Giant Plain 51mm 100 pack"),
    Product(125L, "Paperclip Giant Plain", "Giant Plain Pack of 1000"),
    Product(126L, "No Tear Paper Clip", "No tear extra large pack 1000"),
    Product(127L, "Zebra Paperclips", "Zebra Length 28mm Assorted 150 pack")
  )

  def findAll = products.toList.sortBy(_.ean)
}
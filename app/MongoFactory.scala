package MongoFactory

import com.mongodb.casbah.MongoConnection

object MongoFactory {
  private val SERVER = "localhost"
  private val PORT = 27017
  private val DATABASE = "ensayis"
  private val COLLECTION = "products"
  val connection = MongoConnection(SERVER)
  val collection = connection(DATABASE)(COLLECTION)
}
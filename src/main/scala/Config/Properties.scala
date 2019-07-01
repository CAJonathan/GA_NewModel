package Config

import scala.collection.mutable

class Properties {
  val properties: mutable.Map[String, Any] = mutable.Map()

  def addProperties(key: String, value: Any): Unit = {
    properties += (key -> value)
  }

  def getAsObject(key: String): Any = {
    properties(key)
  }

  def getAsInt(key: String): Int = {
    properties(key).asInstanceOf[Int]
  }

  def getAsDouble(key: String): Double = {
    properties(key).asInstanceOf[Double]
  }

  def getAsString(key: String): String = {
    properties(key).asInstanceOf[String]
  }

  def getAsProperties(key: String): Properties = {
    properties(key).asInstanceOf[Properties]
  }
}

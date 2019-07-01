package Config

import scala.collection.mutable

class Properties {
  val properties: mutable.Map[String, Object] = mutable.Map()

  def addProperties(key: String, value: Object): Unit = {
    properties += (key -> value)
  }

  def getAsObject(key: String): Object = {
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

package Utils

import scala.util.Random

object Utils {

  val generator: Random = new Random()

  def nextArrGaussDouble(mean: Double, standardDeviation: Double, size: Int): Array[Double] = {
    val X = for(i <- 0 to size) yield generator.nextGaussian()*standardDeviation + mean
    X.toArray
  }

  def nextArrGaussDouble(mean: Double, standardDeviation: Double, min: Double, max: Double, size: Int): Array[Double] = {
    val X = for(i <- 0 to size) yield {
      var value: Double = -1.0
      do{
        value = generator.nextGaussian()*standardDeviation + mean
      } while(value < min || value > max)
      value
    }
    X.toArray
  }

  def nextArrUniformDouble(min: Double, max: Double, size: Int): Array[Double] = {
    val X = for(i <- 0 to size) yield generator.nextDouble()*(max - min) + min
    X.toArray
  }
}

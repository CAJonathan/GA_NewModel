package DataGeneration.Utils

import scala.util.Random

class Utils {

  def Utils(): Unit = {

  }

  def randomArrOfNormals(mean: Double, desiredStandardDeviation: Double, min: Double, max: Double, length: Integer): Array[Double] = {
    val values: Array[Double] = new Array[Double](length)
    0 until length foreach(i => {
      values(i) = normalRandom(mean, desiredStandardDeviation, min, max)
    })

    values
  }

  def randomArrOfUniforms(min: Double, max: Double, length: Integer): Array[Double] = {
    val values: Array[Double] = new Array[Double](length)
    0 until length foreach(i => {
      values(i) = uniformRandom(min, max)
    })

    values
  }

  def normalRandom(mean: Double, desiredStandardDeviation: Double, min: Double, max: Double): Double = {
    var value: Double = -1.0
    while(value < min || value > max){
      value = new Random().nextGaussian() * desiredStandardDeviation + mean
    }

    value
  }

  def uniformRandom(min: Double, max: Double): Double ={
    min + new Random().nextDouble() * (max - min)
  }
}
